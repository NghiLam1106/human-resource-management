package com.example.back_end.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginResponse {
    String access_token;
    String accessTokenType = "Bearer ";

    public LoginResponse(String access_token) {
        this.access_token = access_token;
    }
}
