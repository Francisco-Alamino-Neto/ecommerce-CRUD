package com.projeto.ecommerce.controllers;

import com.projeto.ecommerce.DTOs.UserDTO;
import com.projeto.ecommerce.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("usuario")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/salvar")
    public ResponseEntity<UserDTO> save(@Valid @RequestBody UserDTO dto) {
        dto = userService.create(dto);
        return ResponseEntity.ok(dto);
    }

}
