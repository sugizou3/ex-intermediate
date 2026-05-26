package com.example.domain;

import lombok.*;

import java.util.Date;

/**
 * 野球チームを表すドメイン
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Team {
    /**
     * チームID
     */
    private Integer id;

    /**
     * 球団名
     */
    private String name;

    /**
     * 本拠地
     */
    private String homeField;

    /**
     * 発足
     */
    private Date launch;

    /**
     * 歴史
     */
    private String history;

}
