package com.example.back_end.service;

import com.example.back_end.dto.request.RegisterRequest;
import com.example.back_end.dto.response.RegisterResponse;
import com.example.back_end.exception.AppException;
import com.example.back_end.exception.ErrorCode;
import com.example.back_end.mapper.UserMapper;
import com.example.back_end.model.Users;
import com.example.back_end.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;



    public Users login(int id) {
        return userRepository.findById(id).orElse(null);
    }

}
