package com.example.domain;

import lombok.*;

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
     * リーグ名
     */
    private String leagueName;
    /**
     * 球団名
     */
    private String teamName;

    /**
     * 本拠地
     */
    private String headquarters;

    /**
     * 発足
     */
    private String inauguration;

    /**
     * 歴史
     */
    private String history;

}
