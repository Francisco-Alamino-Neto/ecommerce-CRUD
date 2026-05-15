package com.projeto.ecommerce.controllers;

import com.projeto.ecommerce.DTOs.UserDTO;
import com.projeto.ecommerce.entities.UserEntity;
import com.projeto.ecommerce.services.PhotoService;
import com.projeto.ecommerce.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private final UserService userService;
    private final PhotoService photoService;

    public UserController(UserService userService, PhotoService photoService) {
        this.userService = userService;
        this.photoService = photoService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("view/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping("upload")
    public ResponseEntity<?> saveUser(@RequestParam String name
            , @RequestParam String email, @RequestParam MultipartFile photo) throws IOException {

        String pathPhoto = photoService.savePhoto(photo);
        return ResponseEntity.ok(userService.saveUser(name, email, pathPhoto));
    }

    @PostMapping("create")
    public ResponseEntity<UserDTO> create(@RequestBody UserEntity entity) {
        return ResponseEntity.ok(userService.create(entity));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable UUID id, @RequestBody UserDTO dto) {
        return ResponseEntity.ok(userService.update(id, dto));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
