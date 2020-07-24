package com.c7n.spring.data.dataDomain.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Transient;

@Data
@EqualsAndHashCode
public class DoubleKey<T extends AbstractKey, Z extends AbstractKey> {

    @Transient
    private T key1;

    @Transient
    private Z key2;

}
