package com.projeto.ecommerce.DTOs;

import com.projeto.ecommerce.enums.StatusDoPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private UUID id;
    private LocalDate moment;
    private StatusDoPedido status;
    private UUID client;
}
