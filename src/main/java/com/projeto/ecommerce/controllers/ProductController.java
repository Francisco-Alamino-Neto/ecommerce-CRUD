package com.projeto.ecommerce.controllers;

import com.projeto.ecommerce.DTOs.ProductDTO;
import com.projeto.ecommerce.services.PhotoService;
import com.projeto.ecommerce.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RequestMapping("products")
@RestController
public class ProductController {

    private final ProductService productService;
    private final PhotoService photoService;

    public ProductController(ProductService productService, PhotoService photoService) {
        this.productService = productService;
        this.photoService = photoService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("view/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PostMapping("create")
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO dto) {
        return ResponseEntity.ok(productService.create(dto));
    }

    @PostMapping("/upload")
    public ResponseEntity<ProductDTO> uploadProduct(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam double price,
            @RequestParam Set<UUID> categoriesIds,
            @RequestParam MultipartFile photo
    ) throws IOException {

        String pathPhoto = photoService.savePhoto(photo);

        return ResponseEntity.ok(
                productService.saveProduct(
                        name,
                        description,
                        price,
                        pathPhoto,
                        categoriesIds
                )
        );
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable UUID id, @RequestBody ProductDTO dto) {
        return ResponseEntity.ok(productService.update(id, dto));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
