package com.technokratos.mapper;

import com.technokratos.dto.response.RoleResponse;
import com.technokratos.model.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface RoleMapper {

    RoleEntity toEntity(RoleResponse roleResponse);

    @Mapping(target = "description", source = "role.description")
    RoleResponse toResponse(RoleEntity role);
}
