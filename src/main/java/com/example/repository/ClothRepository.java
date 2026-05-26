package com.example.repository;

import com.example.domain.Cloth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * clothesテーブルを操作するリポジトリ.
 */
@Repository
public class ClothRepository {
    RowMapper<Cloth> CLOTH_ROW_MAPPER
            = new BeanPropertyRowMapper<>(Cloth.class);

    @Autowired
    private NamedParameterJdbcTemplate template;

    /**
     * 引数の色と性別に合致する衣類情報を取得する.
     *
     * @param color  色
     * @param gender 性別
     * @return 衣類情報
     */
    public List<Cloth> findByColorAndGender(String color, Integer gender) {
        String sql = """
                SELECT category, genre, gender, color, price, size
                FROM clothes
                WHERE gender = :gender AND color = :color
                """;
        SqlParameterSource param
                = new MapSqlParameterSource()
                .addValue("color", color)
                .addValue("gender", gender);

        return template.query(sql, param, CLOTH_ROW_MAPPER);
    }
}
