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

/**
 * ホテル検索画面の表示を制御するコントローラー.
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {
    @Autowired()
    private HotelService service;

    /**
     * 検索・表示画面を表示する.
     *
     * @return 検索・表示画面
     */
    @GetMapping("/")
    public String index() {

        return "hotel-search";
    }

    /**
     * 入力された価格以下のホテルを表示する.
     *
     * @param price 価格
     * @param model リクエストスコープ
     * @return 検索・表示画面
     */
    @PostMapping("form-post")
    public String formPost(Integer price, Model model) {
        List<Hotel> hotels = service.priceLowPassFilter(price);
        model.addAttribute("hotels", hotels);
        model.addAttribute("price", price);
        return "hotel-search";
    }

}
