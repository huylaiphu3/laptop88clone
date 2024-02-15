package com.example.demo3.controller;

import com.example.demo3.entity.Product;
import com.example.demo3.service.product_service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ProductService productService;
    @GetMapping("/home")
    public String viewHomePage1(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);
        return "list_product";
    }
    @GetMapping("/home2")
    public String viewHomePage2(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);
        return "list_product_user";
    }
}
