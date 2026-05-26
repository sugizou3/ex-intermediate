package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cloth")
public class ClothController {
    @GetMapping("/")
    public String index() {
        return "";
    }

    @PostMapping("/form-post")
    public String formPost() {
        return "";
    }
}
