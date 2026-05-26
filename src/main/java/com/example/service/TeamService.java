package com.example.service;

import com.example.domain.Team;
import com.example.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * チーム情報を取得するメソッドを作成する
 */
@Service
public class TeamService {
    @Autowired
    private TeamRepository repository;

    /**
     * すべてのチーム情報を取得する.
     *
     * @return 全チーム情報
     */
    public List<Team> findAll() {
        return repository.findAll();
    }

    /**
     * idを持つチーム情報を1件取得する.
     *
     * @param id id
     * @return チーム情報
     */
    public Team findById(Integer id) {
        return repository.findById(id);
    }


}
