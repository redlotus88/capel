package com.c7n.sqlite.repository;

import com.c7n.sqlite.model.SQLiteTesterModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * SQLiteTesterRepository
 *
 * @author jialong.wang
 * @Date on 2020/12/30 3:28 PM
 * @since 1.0
 */
public interface SQLiteTesterRepository extends JpaRepository<SQLiteTesterModel, Integer> {

}
