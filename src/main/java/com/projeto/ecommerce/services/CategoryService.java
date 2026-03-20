package com.projeto.ecommerce.services;

import com.projeto.ecommerce.DTOs.CategoryDTO;
import com.projeto.ecommerce.entities.CategoryEntity;
import com.projeto.ecommerce.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public CategoryDTO findById(UUID id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        return toDTO(categoryEntity);
    }

    public CategoryDTO create(CategoryDTO dto) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(dto.getName());

        return toDTO(categoryRepository.save(categoryEntity));
    }

    public CategoryDTO update(UUID id, CategoryDTO dto) {
        CategoryEntity entity = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        entity.setName(dto.getName());

        return toDTO(categoryRepository.save(entity));
    }

    public void delete(UUID id) {
        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Categoria não encontrada");
        }
        categoryRepository.deleteById(id);
    }

    private CategoryDTO toDTO(CategoryEntity entity) {
        return new CategoryDTO(
                entity.getId(),
                entity.getName()
        );
    }
}
