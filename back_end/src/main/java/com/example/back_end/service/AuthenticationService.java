package com.example.back_end.service;

import com.example.back_end.dto.request.LoginRequet;
import com.example.back_end.dto.request.RegisterRequest;
import com.example.back_end.dto.response.LoginResponse;
import com.example.back_end.dto.response.RegisterResponse;
import com.example.back_end.exception.AppException;
import com.example.back_end.exception.ErrorCode;
import com.example.back_end.mapper.RolesMapper;
import com.example.back_end.mapper.UserMapper;
import com.example.back_end.model.Role;
import com.example.back_end.model.Users;
import com.example.back_end.repository.RoleRepository;
import com.example.back_end.repository.UserRepository;
import com.example.back_end.security.JWTGenerator;
import com.example.back_end.security.PasswordEncoderConfiguration;
import com.example.back_end.utils.ProjectConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoderConfiguration passwordEncoder;
    private final RoleRepository roleRepository;
    private final RolesMapper rolesMapper;
    private final AuthenticationManager authenticationManager;
    private final JWTGenerator jwtGenerator;

    public LoginResponse login(LoginRequet request) {
        String username = request.getUsername();
        String password = request.getPassword();

        final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                username, password);
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new AppException(ErrorCode.INVALID_CREDENTIALS);
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtGenerator.generateToken(authentication);
        return new LoginResponse(token);
    }

    public RegisterResponse register(RegisterRequest request) {
        // Check if the user already exists
        Optional<Users> existingUser = userRepository.findByUsername(request.getUsername());
        if (existingUser.isPresent()) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        Users user = userMapper.toUser(request);

        // Encode the password before saving
        user.setPassword(passwordEncoder.encoder().encode(request.getPassword()));

        Role role = roleRepository.findByName(ProjectConstants.ROLE_USER)
                .orElseThrow(() -> new AppException(ErrorCode.ROLE_NOT_FOUND));
        Role roles = rolesMapper.convertToRole(role.getId(), role.getName());

        user.setRole(roles);

        Users savedUser = userRepository.save(user);

        return userMapper.toUserResponse(savedUser);
    }
}
