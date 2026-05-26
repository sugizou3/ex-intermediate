package com.example.domain;

import lombok.*;

/**
 * 衣類を表すドメイン.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cloth {
    /**
     * 衣類ID
     */
    private Integer id;
    /**
     * カテゴリー
     */
    private String category;
    /**
     * ジャンル
     */
    private String genre;
    /**
     * 性別
     */
    private Integer gender;
    /**
     * 色
     */
    private String color;

    /**
     * 価格
     */
    private Integer price;
    /**
     * サイズ
     */
    private String size;

}
