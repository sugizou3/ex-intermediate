package com.example.service;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ホテル情報を取得するメソッドを記述する
 */
@Service
public class HotelService {
    @Autowired
    private HotelRepository repository;

    public List<Hotel> priceLowPassFilter(Integer price) {
        return repository.priceLowPassFilter(price);
    }
}

