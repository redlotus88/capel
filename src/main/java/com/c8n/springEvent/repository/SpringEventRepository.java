package com.c8n.springEvent.repository;

import com.c8n.springEvent.bean.SpringEventBean;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dragon on 2020/1/21.
 */
public interface SpringEventRepository extends JpaRepository<SpringEventBean, Integer> {

}
