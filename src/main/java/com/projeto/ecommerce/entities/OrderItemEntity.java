package com.projeto.ecommerce.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderItemEntity {
    @EmbeddedId
    private OrderItemPKEntity id = new OrderItemPKEntity();
    private Integer quantity;
    private Double price;

    public OrderItemEntity(OrderEntity order, ProductEntity product, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    public OrderEntity getOrder() {
        return id.getOrder();
    }

    public ProductEntity getProduct() {
        return id.getProduct();
    }
}