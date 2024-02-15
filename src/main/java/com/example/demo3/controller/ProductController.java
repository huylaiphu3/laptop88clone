package com.example.demo3.controller;

import com.example.demo3.entity.Product;
import com.example.demo3.service.product_service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public String getAllProduct(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);
        return "list_product_user";
    }
    @GetMapping("/add")
    public String addProduct(Model model){
        Product product = new Product();
        model.addAttribute("product",product);
        return "list_product";
    }
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product){
        productService.save(product);
        return "redirect:/product/list";
    }
    @GetMapping("/update")
    public String updateProduct(@RequestParam("productId") int id,Model model){
        Optional<Product> product = productService.findById(id);
        model.addAttribute("product",product);
        return "redirect:/product/list";
    }
    @GetMapping("/delete")
    public String deleteProduct(@RequestParam("productId") int id){
        productService.deleteById(id);
        return "redirect:/product/list";
    }

    @GetMapping("/search1")
    public String searchProduct1(@RequestParam(value = "ram", required = false) Integer ram,
                                @RequestParam(value = "ssd", required = false) Integer ssd,
                                @RequestParam(value = "priceRange", required = false) Integer price,
                                Model model) {
        List<Product> products;
        if (ram != null && ssd != null && price != null) {
            // Tìm kiếm sản phẩm dựa trên tất cả các tham số
            products = productService.findAllByRamOrSsdOrPrice(ram, ssd, price);
        } else if (ram != null && ssd != null) {
            // Tìm kiếm sản phẩm dựa trên RAM và SSD
            products = productService.findAllyRamOrSsd(ram, ssd);
        } else if (ram != null && price != null) {
            // Tìm kiếm sản phẩm dựa trên RAM và giá
            products = productService.findAllByRamOrPrice(ram, price);
        } else if (ssd != null && price != null) {
            // Tìm kiếm sản phẩm dựa trên SSD và giá
            products = productService.findAllBySsdOrPrice(ssd, price);
        } else if (ram != null) {
            // Tìm kiếm sản phẩm dựa trên RAM
            products = productService.findAllByRam(ram);
        } else if (ssd != null) {
            // Tìm kiếm sản phẩm dựa trên SSD
            products = productService.findAllBySsd(ssd);
        } else if (price != null) {
            // Tìm kiếm sản phẩm dựa trên giá
            products = productService.findAllByPrice(price);
        } else {
            // Xử lý trường hợp không có tham số
            // Ví dụ: Hiển thị tất cả sản phẩm
            products = productService.findAll();
        }
        model.addAttribute("searchProduct", products);
        return "search_result";
    }

    @GetMapping("/search2")
    public String searchProduct2(@RequestParam(value = "ram", required = false) Integer ram,
                                @RequestParam(value = "ssd", required = false) Integer ssd,
                                @RequestParam(value = "priceRange", required = false) Integer price,
                                Model model) {
        List<Product> products;
        if (ram != null && ssd != null && price != null) {
            // Tìm kiếm sản phẩm dựa trên tất cả các tham số
            products = productService.findAllByRamOrSsdOrPrice(ram, ssd, price);
        } else if (ram != null && ssd != null) {
            // Tìm kiếm sản phẩm dựa trên RAM và SSD
            products = productService.findAllyRamOrSsd(ram, ssd);
        } else if (ram != null && price != null) {
            // Tìm kiếm sản phẩm dựa trên RAM và giá
            products = productService.findAllByRamOrPrice(ram, price);
        } else if (ssd != null && price != null) {
            // Tìm kiếm sản phẩm dựa trên SSD và giá
            products = productService.findAllBySsdOrPrice(ssd, price);
        } else if (ram != null) {
            // Tìm kiếm sản phẩm dựa trên RAM
            products = productService.findAllByRam(ram);
        } else if (ssd != null) {
            // Tìm kiếm sản phẩm dựa trên SSD
            products = productService.findAllBySsd(ssd);
        } else if (price != null) {
            // Tìm kiếm sản phẩm dựa trên giá
            products = productService.findAllByPrice(price);
        } else {
            // Xử lý trường hợp không có tham số
            // Ví dụ: Hiển thị tất cả sản phẩm
            products = productService.findAll();
        }
        model.addAttribute("searchProduct", products);
        return "search_result_user";
    }

}
