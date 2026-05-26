package com.example.controller;

import com.example.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hotel")
public class HotelController {
    @Autowired()
    private HotelService service;

    @GetMapping("/")
    public String index() {

        return "hotel-search";
    }

    @PostMapping("form-post")
    public String formPost(Integer price) {

        return "hotel-search";
    }

}
