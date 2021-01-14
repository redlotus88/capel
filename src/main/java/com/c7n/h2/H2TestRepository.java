package com.c7n.h2;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <功能描述>
 *
 * @author jialong.wang
 * @Date on 2021/1/14 1:30 PM
 * @since 1.0
 */
public interface H2TestRepository extends JpaRepository<H2TestModel, Long> {

    List<H2TestModel> getH2TestModelByType(String type);
}
