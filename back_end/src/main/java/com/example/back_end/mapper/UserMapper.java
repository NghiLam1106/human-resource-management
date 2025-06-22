package com.example.back_end.mapper;

import com.example.back_end.dto.request.RegisterRequest;
import com.example.back_end.dto.response.RegisterResponse;
import com.example.back_end.model.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    Users toUser(RegisterRequest request);
    RegisterResponse toUserResponse(Users user);
}
