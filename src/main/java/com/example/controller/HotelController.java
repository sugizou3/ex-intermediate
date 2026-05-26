package com.example.controller;

import com.example.domain.Hotel;
import com.example.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
    public String formPost(Integer price, Model model) {
        List<Hotel> hotels = service.priceLowPassFilter(price);
        model.addAttribute("hotels", hotels);
        model.addAttribute("price", price);
        return "hotel-search";
    }

}
