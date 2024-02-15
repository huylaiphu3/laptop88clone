package com.example.demo3.service.cart_iterm_service;

import com.example.demo3.entity.CartProduct;

import java.util.List;

public interface ShoppingCartService {
    public CartProduct add(CartProduct cartProduct);
    public void remove(int id);
    public CartProduct save(CartProduct cartProduct);
    public List<CartProduct> getAll();
    public CartProduct findByProductId(int id);
}
