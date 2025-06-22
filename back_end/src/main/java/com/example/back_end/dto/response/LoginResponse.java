package com.example.back_end.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginResponse {
    String accessToken;
    String accessTokenType = "Bearer ";

    public LoginResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
