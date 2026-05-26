package com.example.repository;

import com.example.domain.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HotelRepository {
    RowMapper<Hotel> HOTEL_ROW_MAPPER
            = new BeanPropertyRowMapper<>(Hotel.class);

    @Autowired
    private NamedParameterJdbcTemplate template;

    /**
     * 引数の値段以下のホテル情報を取得する.
     *
     * @param price 値段の閾値
     * @return ホテル情報
     */
    public List<Hotel> moneyLowPassFilter(Integer price) {
        String sql = """
                SELECT area_name, hotel_name, address, nearest_station, price, parking FROM hotels
                WHERE price <= :price
                """;
        SqlParameterSource param
                = new MapSqlParameterSource()
                .addValue("price", price);

        return template.query(sql, param, HOTEL_ROW_MAPPER);
    }
}
