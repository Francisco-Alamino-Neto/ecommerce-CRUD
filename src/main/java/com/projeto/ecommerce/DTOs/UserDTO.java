package com.projeto.ecommerce.DTOs;

import com.projeto.ecommerce.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private UUID id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private RoleEnum roles;

    public UserDTO(UUID id, String name, String email, String phone, RoleEnum roles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.roles = roles;
    }
}
