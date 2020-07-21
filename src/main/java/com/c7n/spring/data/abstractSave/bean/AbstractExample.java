package com.c7n.spring.data.abstractSave.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractExample {

    /**
     * uuid 自动生成
     */
    @Id
    @Column(nullable = false, unique = true, length = 32)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected int id;

    @Column
    protected String abstractValue;

}
