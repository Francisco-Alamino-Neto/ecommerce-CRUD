package com.projeto.ecommerce.services;

import com.projeto.ecommerce.DTOs.OrderDTO;
import com.projeto.ecommerce.entities.OrderEntity;
import com.projeto.ecommerce.entities.UserEntity;
import com.projeto.ecommerce.repositories.OrderRepository;
import com.projeto.ecommerce.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public List<OrderDTO> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public OrderDTO findById(UUID id) {
        OrderEntity orderEntity = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        return toDTO(orderEntity);
    }

    public OrderDTO create(OrderDTO dto) {
        UserEntity userEntity = userRepository.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setMoment(LocalDate.now());
        orderEntity.setStatus(dto.getStatus());
        orderEntity.setClient(userEntity);

        return toDTO(orderRepository.save(orderEntity));
    }

    public OrderDTO update(UUID id, OrderDTO dto) {
        OrderEntity orderEntity = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        orderEntity.setStatus(dto.getStatus());

        if (dto.getClientId() != null) {
            UserEntity userEntity = userRepository.findById(dto.getClientId())
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
            orderEntity.setClient(userEntity);
        }

        return toDTO(orderRepository.save(orderEntity));
    }

    public void delete(UUID id) {
        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Pedido não encontrado");
        }
        orderRepository.deleteById(id);
    }

    private OrderDTO toDTO(OrderEntity orderEntity) {
        return new OrderDTO(
                orderEntity.getId(),
                orderEntity.getMoment(),
                orderEntity.getStatus(),
                orderEntity.getClient().getId()
        );
    }
}
