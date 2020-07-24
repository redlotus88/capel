package com.c7n.spring.data.dataDomain.bean;

import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode
@MappedSuperclass
public abstract class AbstractKey {

    /**
     * uuid 自动生成
     */
    @Id
    @Column(nullable = false, unique = true, length = 32)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected int id;
}
