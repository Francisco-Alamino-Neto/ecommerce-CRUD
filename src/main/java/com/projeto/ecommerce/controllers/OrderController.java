package com.projeto.ecommerce.controllers;

import com.projeto.ecommerce.DTOs.OrderDTO;
import com.projeto.ecommerce.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderService service;


    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody OrderDTO dto) {
        dto = orderService.create(dto);
        return ResponseEntity.ok("Criado ocom sucesso!");
    }
}
