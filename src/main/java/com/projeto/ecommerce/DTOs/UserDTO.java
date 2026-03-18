package com.projeto.ecommerce.DTOs;

import com.projeto.ecommerce.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String name;
    private String email;
    private String phone;
    private String password;
    private RoleEnum roles;
}
