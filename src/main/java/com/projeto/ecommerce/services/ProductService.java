package com.projeto.ecommerce.services;

import com.projeto.ecommerce.DTOs.ProductDTO;
import com.projeto.ecommerce.entities.CategoryEntity;
import com.projeto.ecommerce.entities.ProductEntity;
import com.projeto.ecommerce.repositories.CategoryRepository;
import com.projeto.ecommerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository,
                          CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<ProductDTO> findAll() {
        return productRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO findById(UUID id) {
        ProductEntity entity = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        return toDTO(entity);
    }

    public ProductDTO create(ProductDTO dto) {
        ProductEntity productEntity = new ProductEntity();

        productEntity.setName(dto.getName());
        productEntity.setDescription(dto.getDescription());
        productEntity.setPrice(dto.getPrice());
        productEntity.setImgURL(dto.getImgURL());

        Set<CategoryEntity> categories = dto.getCategoriesIds()
                .stream()
                .map(catId -> categoryRepository.findById(catId)
                        .orElseThrow(() -> new RuntimeException("Categoria não encontrada")))
                .collect(Collectors.toSet());

        productEntity.setCategories(categories);

        return toDTO(productRepository.save(productEntity));
    }

    public ProductDTO update(UUID id, ProductDTO dto) {
        ProductEntity entity = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgURL(dto.getImgURL());

        entity.getCategories().clear();

        Set<CategoryEntity> categories = dto.getCategoriesIds()
                .stream()
                .map(catId -> categoryRepository.findById(catId)
                        .orElseThrow(() -> new RuntimeException("Categoria não encontrada")))
                .collect(Collectors.toSet());

        entity.setCategories(categories);

        return toDTO(productRepository.save(entity));
    }

    public void delete(UUID id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado");
        }
        productRepository.deleteById(id);
    }

    private ProductDTO toDTO(ProductEntity productEntity) {
        return new ProductDTO(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getPrice(),
                productEntity.getImgURL(),
                productEntity.getCategories().stream().map(CategoryEntity::getId).collect(Collectors.toSet())
        );
    }
}
