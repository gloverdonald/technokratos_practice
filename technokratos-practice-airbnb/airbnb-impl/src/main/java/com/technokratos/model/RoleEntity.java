package com.technokratos.model;


import com.technokratos.dto.enums.Role;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@ToString
@Table(name = "roles")
public class RoleEntity extends AbstractEntity {

    @Enumerated(EnumType.STRING)
    @Column(length = 64)
    private Role role;
}
