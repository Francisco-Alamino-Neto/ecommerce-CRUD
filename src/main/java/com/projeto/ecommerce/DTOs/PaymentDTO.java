package com.projeto.ecommerce.DTOs;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {

    @Id
    private UUID id;
    private Instant moment;
}
