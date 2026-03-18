package com.projeto.ecommerce.services;

import com.projeto.ecommerce.DTOs.OrderDTO;
import com.projeto.ecommerce.entities.OrderEntity;
import com.projeto.ecommerce.enums.StatusDoPedido;
import com.projeto.ecommerce.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderDTO create(OrderDTO dto){
        OrderEntity order = new OrderEntity();
        order.setMoment(LocalDate.now());
        order.setStatus(StatusDoPedido);
        orderRepository.save(dto);
        return new OrderDTO(order);
    }
}
