package com.example.demo3.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cart_product")
public class CartProduct {
    @Id
    @Column(name="product_id")
    private int productId;
    @Column(name="name")
    private String name;
    @Column(name="price")
    private int price;
    @Column(name="quantity")
    private int quantity = 1;

    public CartProduct() {
    }

    public CartProduct(int productId, String name, int price, int quantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
