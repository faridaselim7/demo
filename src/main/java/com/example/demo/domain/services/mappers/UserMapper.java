package com.example.demo.domain.services.mappers;

import com.example.demo.domain.entities.User;
import com.example.demo.web.models.UserCreateRequest;
import com.example.demo.web.models.UserCreateResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User mapToEntity(UserCreateRequest dto);
    UserCreateResponse toResponse(User entity);
}
