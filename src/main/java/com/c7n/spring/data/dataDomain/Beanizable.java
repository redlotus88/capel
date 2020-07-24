package com.c7n.spring.data.dataDomain;

/**
 * Dto to entity
 */
public interface Beanizable<T> {

    T toEntity();
}
