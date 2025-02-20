package com.gabrielpongelupe.dscommerce.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_order_item")
public class OrderItem {

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    private int quantity;

    private double price;

    public OrderItem() {
    }

    public OrderItem(Order order, Product product, int quantity, double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    public Product getProduct() {
        return id.getProduct();
    }

    public void setProduct(Product product) {
        this.id.setProduct(product);
    }

    public Order getOrder() {
        return id.getOrder();
    }

    public void setOrder(Order order) {
        this.id.setOrder(order);
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
