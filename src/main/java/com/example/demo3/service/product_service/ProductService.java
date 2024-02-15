package com.example.demo3.service.product_service;

import com.example.demo3.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public List<Product> findAll();

    public Optional<Product> findById(int id);

    public Product save(Product employee);

    public void deleteById(int id);

    public Product findByPrice(int price);

    public Product findBySsd(int ssd);

    public List<Product> findAllByRam(int ram);
    public List<Product> findAllByRamOrSsdOrPrice(int ram , int ssd , int price);
    public List<Product> findAllyRamOrSsd(int ram , int ssd);
    public List<Product> findAllByRamOrPrice(int ram , int price);
    public List<Product> findAllBySsdOrPrice(int ssd , int price);
    public List<Product> findAllBySsd(int ssd);
    public List<Product> findAllByPrice(int price);
}

