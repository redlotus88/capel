package com.c7n.spring.data.dataDomain.repository;

import com.c7n.spring.data.dataDomain.bean.AbstractKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeyRepository extends JpaRepository<AbstractKey, Integer> {
}
