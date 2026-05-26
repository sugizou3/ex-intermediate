package com.example.service;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ホテル情報を取得するメソッドを記述する.
 */
@Service
public class HotelService {
    @Autowired
    private HotelRepository repository;

    /**
     * 引数の価格以下のホテル情報を取得する.
     *
     * @param price 価格
     * @return ホテル情報
     */
    public List<Hotel> priceLowPassFilter(Integer price) {
        System.out.println(price);
        if (price == null) {
            return repository.findAll();
        }
        return repository.findByLessThanPrice(price);
    }

}

