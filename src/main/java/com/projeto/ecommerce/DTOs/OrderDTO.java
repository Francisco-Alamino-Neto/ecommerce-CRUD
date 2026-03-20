package com.projeto.ecommerce.DTOs;

import com.projeto.ecommerce.enums.StatusDoPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private UUID id;
    private LocalDate moment;
    private StatusDoPedido status;
    private UUID clientId;
}
