package com.example.back_end.mapper;

import com.example.back_end.model.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface  RolesMapper {
    Role convertToRole(Integer id, String name);
}
