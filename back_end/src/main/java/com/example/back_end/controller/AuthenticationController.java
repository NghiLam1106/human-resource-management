package com.example.back_end.controller;

import com.example.back_end.dto.request.LoginRequet;
import com.example.back_end.dto.request.RegisterRequest;
import com.example.back_end.dto.response.ApiResponse;
import com.example.back_end.dto.response.LoginResponse;
import com.example.back_end.dto.response.RegisterResponse;
import com.example.back_end.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/login")
    ApiResponse<LoginResponse> login(@RequestBody LoginRequet request) {
        var token = authenticationService.login(request);
        return ApiResponse.<LoginResponse>builder()
                .result(LoginResponse.builder()
                    .access_token(token.getAccess_token())
                    .refresh_token(token.getRefresh_token())
                    .accessTokenType(token.getAccessTokenType())
                    .build())
            .build();
    }

    @PostMapping("/register")
    ApiResponse<RegisterResponse> register(@RequestBody RegisterRequest userCreateDto) {
        var user = authenticationService.register(userCreateDto);
            return ApiResponse.<RegisterResponse>builder()
                .result(RegisterResponse.builder()
                    .username(user.getUsername())
                    .id(user.getId())
                    .build())
            .build();
    }

    @PostMapping("/refresh-token")
    ApiResponse<String> refreshToken(@RequestBody String refreshToken) {
        var token = authenticationService.refreshToken(refreshToken);
        return ApiResponse.<String>builder()
                .result(token)
            .build();
    }
}
