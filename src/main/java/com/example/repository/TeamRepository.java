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

    /**
     * 全チーム情報を取得する.
     *
     * @return 全チーム情報
     */
    public List<Team> findAll() {
        String sql = """
                SELECT id, league_name, team_name, headquarters, inauguration, history 
                FROM teams;
                ORDER BY inauguration DESC
                """;
        SqlParameterSource param
                = new MapSqlParameterSource();

        return template.query(sql, param, TEAM_ROW_MAPPER);
    }

    /**
     * idに紐づいたチーム情報を取得する
     *
     * @param id id
     * @return チーム情報
     */
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
