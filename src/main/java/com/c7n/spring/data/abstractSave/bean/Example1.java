package com.c7n.spring.data.abstractSave.bean;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "com_c7n_spring_data_abstractSave_example1")
public class Example1 extends AbstractExample {

    @Column
    private String test1;
}
