package com.c7n.spring.data.dataDomain.bean;

import com.c7n.spring.data.dataDomain.IDataDomainial;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "com.c7n.spring.data.dataDomain.key1")
@Data
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class Key1 extends AbstractKey implements IDataDomainial {

    @Column
    private String k1_1;

    @Column
    private String k1_2;

    @Column
    private String k1_3;
}
