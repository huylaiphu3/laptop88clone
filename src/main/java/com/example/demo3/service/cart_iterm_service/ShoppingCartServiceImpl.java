package com.example.demo3.service.cart_iterm_service;

import com.example.demo3.dao.ShoppingCartRepository;
import com.example.demo3.entity.CartProduct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Override
    public CartProduct add(CartProduct cartProduct) {
        CartProduct existingProduct = shoppingCartRepository.findByProductId(cartProduct.getProductId());
        if (existingProduct != null) {
            existingProduct.setQuantity(existingProduct.getQuantity() + 1);
            return shoppingCartRepository.save(existingProduct);
        } else {
            return shoppingCartRepository.save(cartProduct);
        }
    }

    @Override
    public CartProduct findByProductId(int id) {
        CartProduct cartProduct = shoppingCartRepository.findByProductId(id);
        return cartProduct;
    }

    @Override
    @Transactional
    public void remove(int id) {
        CartProduct cartProduct = shoppingCartRepository.findByProductId(id);
        if (cartProduct != null) {
            if (cartProduct.getQuantity() > 1) {
                cartProduct.setQuantity(cartProduct.getQuantity() - 1);
                shoppingCartRepository.save(cartProduct);
            } else if (cartProduct.getQuantity() ==1){
                shoppingCartRepository.deleteByProductId(id);
            }
        }
    }

    @Override
    public CartProduct save(CartProduct cartProduct) {
        return shoppingCartRepository.save(cartProduct);
    }

    @Override
    public List<CartProduct> getAll() {
        return shoppingCartRepository.findAll();
    }
}
