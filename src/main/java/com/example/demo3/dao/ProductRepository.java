package com.example.demo3.dao;

import com.example.demo3.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByPrice(int price);

    Product findBySsd(int ssd);
    List<Product> findAllByRam(int ram);
    List<Product> findAllByRamOrSsdOrPrice(int ram , int ssd , int price);
    List<Product> findAllByRamOrSsd(int ram , int ssd);
    List<Product> findAllByRamOrPrice(int ram , int price);
    List<Product> findAllBySsdOrPrice(int ssd , int price);
    List<Product> findAllBySsd(int ssd);
    List<Product> findAllByPrice(int price);

}
