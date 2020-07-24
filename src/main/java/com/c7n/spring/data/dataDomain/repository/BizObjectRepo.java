package com.c7n.spring.data.dataDomain.repository;

import com.c7n.spring.data.dataDomain.bean.BizObject;
import org.springframework.data.repository.CrudRepository;

public interface BizObjectRepo extends CrudRepository<BizObject, Integer> {
}
