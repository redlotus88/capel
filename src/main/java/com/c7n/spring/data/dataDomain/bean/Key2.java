package com.c7n.spring.data.dataDomain.bean;

import com.c7n.spring.data.dataDomain.IDataDomainial;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "com.c7n.spring.data.dataDomain.key2")
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Key2 extends AbstractKey implements IDataDomainial {

    @Column
    private String k2_1;

    @Column
    private String k2_2;

    @Column
    private String k3_2;
}
