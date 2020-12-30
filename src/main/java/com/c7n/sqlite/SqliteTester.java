package com.c7n.sqlite;

import com.c7n.Application;
import com.c7n.sqlite.model.SQLiteTesterModel;
import com.c7n.sqlite.repository.SQLiteTesterRepository;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SqliteTester
 *
 * @author jialong.wang
 * @Date on 2020/12/30 3:00 PM
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
@NoArgsConstructor
@ActiveProfiles("devSqlite")
public class SqliteTester {

    @Autowired
    SQLiteTesterRepository sqLiteTesterRepository;

    @Test
    public void test001Init() {
        log.info("====== Start SQLite Test 001 Init ======");
        SQLiteTesterModel model = new SQLiteTesterModel();
        model.setText("test1");
        sqLiteTesterRepository.save(model);
        log.info("====== End SQLite Test 001 Init ======");
    }
}
