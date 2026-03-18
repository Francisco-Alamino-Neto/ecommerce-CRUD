package com.projeto.ecommerce.services;

import com.projeto.ecommerce.DTOs.UserDTO;
import com.projeto.ecommerce.entities.UserEntity;
import com.projeto.ecommerce.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO criarUsuario(UserDTO dto) {
        UserEntity user = new UserEntity(dto.getName(), dto.getEmail(), dto.getPhone(), dto.getPassword(), dto.getRoles());
        userRepository.save(dto);
        UserDTO userDTO = new UserDTO(user.getName(), user.getEmail(), user.getPhone(), user.getPassword(), user.getRoles());
        return userDTO;
    }
}
