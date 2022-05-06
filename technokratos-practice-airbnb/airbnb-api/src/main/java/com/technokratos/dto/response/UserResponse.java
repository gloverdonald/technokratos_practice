package com.technokratos.dto.response;

import com.technokratos.dto.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private UUID id;

    private String email;

    private String firstName;

    private String lastName;

    private List<RoleResponse> roles;
}
