package com.example.demo3.dao;

import com.example.demo3.entity.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<CartProduct,Integer> {
    public CartProduct findByProductId(int id);
    public void deleteByProductId(int id);
}
