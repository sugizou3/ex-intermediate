package com.example.controller;

import com.example.domain.Team;
import com.example.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/team")

public class TeamController {
    @Autowired
    private TeamService service;

    /**
     * チーム一覧表示
     *
     * @param model リクエストスコープ
     * @return チーム一覧表示画面
     */
    @GetMapping("/")
    public String teamList(Model model) {
        List<Team> teams = service.findAll();
        model.addAttribute("teams", teams);
        System.out.println(teams);
        return "team-list";
    }

    /**
     * チームの詳細表示
     *
     * @param id    id
     * @param model リクエストスコープ
     * @return チーム詳細画面表示
     */
    @GetMapping("/detail")
    public String teamDetail(Integer id, Model model) {
        Team team = service.findById(id);
        model.addAttribute("team", team);
        return "team-detail";
    }
    
}
