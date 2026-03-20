package com.projeto.ecommerce.services;

import com.projeto.ecommerce.DTOs.PaymentDTO;
import com.projeto.ecommerce.entities.OrderEntity;
import com.projeto.ecommerce.entities.PaymentEntity;
import com.projeto.ecommerce.repositories.OrderRepository;
import com.projeto.ecommerce.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    public PaymentService(PaymentRepository paymentRepository,
                          OrderRepository orderRepository) {
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }

    public List<PaymentDTO> findAll() {
        return paymentRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public PaymentDTO findById(UUID id) {
        PaymentEntity entity = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));

        return toDTO(entity);
    }

    public PaymentDTO create(PaymentDTO dto) {
        OrderEntity orderEntity = orderRepository.findById(dto.getOrderId())
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setMoment(Instant.now());
        paymentEntity.setOrderId(orderEntity);

        return toDTO(paymentRepository.save(paymentEntity));
    }

    public PaymentDTO update(UUID id, PaymentDTO dto) {
        PaymentEntity paymentEntity = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));

        paymentEntity.setMoment(dto.getMoment());

        return toDTO(paymentRepository.save(paymentEntity));
    }

    public void delete(UUID id) {
        if (!paymentRepository.existsById(id)) {
            throw new RuntimeException("Pagamento não encontrado");
        }
        paymentRepository.deleteById(id);
    }

    private PaymentDTO toDTO(PaymentEntity paymentEntity) {
        return new PaymentDTO(
                paymentEntity.getId(),
                paymentEntity.getMoment(),
                paymentEntity.getOrderId().getId()
        );
    }
}
