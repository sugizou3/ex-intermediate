package com.example.repository;

import com.example.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeamRepository {
    RowMapper<Team> TEAM_ROW_MAPPER
            = new BeanPropertyRowMapper<>(Team.class);

    @Autowired
    private NamedParameterJdbcTemplate template;

    public List<Team> findAll() {
        String sql = """
                SELECT  league_name, team_name, headquarters, inauguration, history 
                FROM teams;
                """;
        SqlParameterSource param
                = new MapSqlParameterSource();

        return template.query(sql, param, TEAM_ROW_MAPPER);
    }

    public Team findById(Integer id) {
        String sql = """
                SELECT  league_name, team_name, headquarters, inauguration, history 
                FROM teams
                WHERE id = :id;
                """;
        SqlParameterSource param
                = new MapSqlParameterSource()
                .addValue("id", id);

        return template.queryForObject(sql, param, TEAM_ROW_MAPPER);
    }
}
