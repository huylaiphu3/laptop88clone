package com.example.demo3.controller;

import com.example.demo3.dao.UserRepository;
import com.example.demo3.entity.Product;
import com.example.demo3.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller

public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegistration(User user,Model model) {
        User checkUser = userRepository.findByEmail(user.getEmail());
        if (checkUser != null) {
            model.addAttribute("error","Email đã tồn tại");
            return "signup_form";
        } else {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedPassword = encoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            userRepository.save(user);
            return "register_success";
        }
    }
}
