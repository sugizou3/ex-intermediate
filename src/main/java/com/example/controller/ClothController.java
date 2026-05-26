package com.example.controller;

import com.example.domain.Cloth;
import com.example.service.ClothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 衣類検索画面を操作するコントローラ.
 */
@Controller
@RequestMapping("/cloth")
public class ClothController {
    @Autowired
    private ClothService service;

    /**
     * 衣類検索画面の表示.
     *
     * @return 衣類検索画面
     */
    @GetMapping("/")
    public String index() {
        return "cloth-search";
    }

    /**
     * 衣類検索を行う.
     *
     * @return 衣類検索画面
     */
    @PostMapping("/form-post")
    public String formPost(String color, Integer gender, Model model) {
        List<Cloth> clothes = service.searchByColorAndGender(color, gender);
        model.addAttribute("clothes", clothes);
        return "cloth-search";
    }
}
