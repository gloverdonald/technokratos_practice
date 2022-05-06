package com.technokratos.mapper;

import com.technokratos.dto.request.RegistrationRequest;
import com.technokratos.dto.response.UserResponse;
import com.technokratos.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, uses = RoleMapper.class)
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "hashPassword", source = "password")
    @Mapping(target = "updateDate", ignore = true)
    @Mapping(target = "roles", ignore = true)
    UserEntity toEntity(RegistrationRequest registrationRequest);

    UserResponse toResponse(UserEntity userEntity);
}
