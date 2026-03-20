package com.projeto.ecommerce.entities;

import com.projeto.ecommerce.enums.StatusDoPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private LocalDate moment;
    private StatusDoPedido status;
    //  Anotation pra falar que é uma relação de muitos pra 1
    @ManyToOne
    //  define qual coluna será usada como chave estrangeira na tabela
    @JoinColumn(name  = "cliente_id")
    private UserEntity clientId;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private PaymentEntity payment;

    @OneToMany(mappedBy = "id.order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderItemEntity> items = new HashSet<>();

    public List<ProductEntity> getProduct() {
        return items.stream().map(OrderItemEntity::getProduct).toList();
    }
}
