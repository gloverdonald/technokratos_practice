package com.technokratos.dto.request;

import com.technokratos.dto.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest extends LoginRequest {

    private String firstName;

    private String lastName;

    private List<Role> roles;
}
