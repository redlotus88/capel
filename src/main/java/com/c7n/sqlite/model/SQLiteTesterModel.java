package com.c7n.sqlite.model;

import lombok.Data;

import javax.persistence.*;

/**
 * SQLiteTesterModel
 *
 * @author jialong.wang
 * @Date on 2020/12/30 3:22 PM
 * @since 1.0
 */
@Entity(name = "com.c7n.sqlite.model.SQLiteTesterModel")
@Data
public class SQLiteTesterModel {

    /**
     * uuid 自动生成
     */
    @Id
    @Column(nullable = false, unique = true, length = 32)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected int id;

    @Column
    private String text;
}
