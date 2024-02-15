package com.example.demo3.controller;

import com.example.demo3.entity.CartProduct;
import com.example.demo3.entity.Product;
import com.example.demo3.service.cart_iterm_service.ShoppingCartService;
import com.example.demo3.service.product_service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/shopping-cart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private ProductService productService;
    @GetMapping("add/{id}")
    public String addCart(@PathVariable("id") int id) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            CartProduct item = new CartProduct();
            item.setProductId(product.getId());
            item.setName(product.getName());
            item.setPrice(product.getPrice());
            item.setQuantity(1);
            shoppingCartService.add(item);
        }
        return "redirect:/shopping-cart/views";
    }
    @GetMapping("/removeFromCart")
    public String removeFromCart(@RequestParam("cartId") int productId) {
        CartProduct cartProduct = shoppingCartService.findByProductId(productId);
        if (cartProduct != null){
            shoppingCartService.remove(cartProduct.getProductId());
        }
        return "redirect:/shopping-cart/views";
    }
    @GetMapping("/views")
    public String viewCarts(Model model){
        int totalPrice=0;
        List<CartProduct> cartProducts = shoppingCartService.getAll();
        model.addAttribute("carts",cartProducts);
        for (CartProduct item : cartProducts) {
            totalPrice += item.getPrice() * item.getQuantity();
        }
        model.addAttribute("totalPrice",totalPrice);
        return "cart_item";
    }
}
