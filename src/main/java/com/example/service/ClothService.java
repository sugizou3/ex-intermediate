package com.example.service;

import com.example.domain.Cloth;
import com.example.repository.ClothRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothService {
    @Autowired
    private ClothRepository repository;

    /**
     * 引数の色と性別に合致する衣類情報を取得する.
     *
     * @param color  色
     * @param gender 性別
     * @return 衣類情報
     */
    public List<Cloth> searchByColorAndGender(String color, Integer gender) {
        return repository.findByColorAndGender(color, gender);
    }

}
