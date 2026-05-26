package com.example.domain;

import lombok.*;

/**
 * ホテルを表すドメイン.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Hotel {
    /**
     * ホテルID
     */
    private Integer id;

    /**
     * 場所
     */
    private String areaName;

    /**
     * ホテル名
     */
    private String hotelName;

    /**
     * 住所
     */
    private String address;

    /**
     * 最寄り駅
     */
    private String nearestStation;

    /**
     * 価格
     */
    private Integer price;

    /**
     * 駐車場
     */
    private String parking;


}
