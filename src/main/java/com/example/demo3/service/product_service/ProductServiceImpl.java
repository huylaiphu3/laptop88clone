package com.example.demo3.service.product_service;

import com.example.demo3.dao.ProductRepository;
import com.example.demo3.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(int id) {
        Optional<Product> product = productRepository.findById(id);
        return product;
    }

    @Override
    public Product findBySsd(int ssd) {
        Product product = productRepository.findBySsd(ssd);
        return product;
    }

    @Override
    public List<Product> findAllByRam(int ram) {
        return productRepository.findAllByRam(ram);
    }


    @Override
    public Product findByPrice(int price) {
        Product product = productRepository.findByPrice(price);
        return product;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAllByRamOrSsdOrPrice(int ram, int ssd, int price) {
        return productRepository.findAllByRamOrSsdOrPrice(ram,ssd,price);
    }

    @Override
    public List<Product> findAllyRamOrSsd(int ram, int ssd) {
        return productRepository.findAllByRamOrSsd(ram,ssd);
    }

    @Override
    public List<Product> findAllByRamOrPrice(int ram, int price) {
        return productRepository.findAllByRamOrPrice(ram, price);
    }

    @Override
    public List<Product> findAllBySsdOrPrice(int ssd, int price) {
        return productRepository.findAllBySsdOrPrice(ssd, price);
    }

    @Override
    public List<Product> findAllBySsd(int ssd) {
        return productRepository.findAllBySsd(ssd);
    }

    @Override
    public List<Product> findAllByPrice(int price) {
        return productRepository.findAllByPrice(price);
    }
}
