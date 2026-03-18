package com.projeto.ecommerce.entities;

import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.Instant;
import java.util.UUID;

@Entity
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private Instant moment;

    @OneToOne
    @JoinColumn(name="order_id")
    private OrderEntity order;
}
