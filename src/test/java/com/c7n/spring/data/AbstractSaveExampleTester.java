package com.c7n.spring.data;

import com.c7n.ApplicationTest;
import com.c7n.spring.data.abstractSave.bean.Example1;
import com.c7n.spring.data.abstractSave.repository.Example1Repository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApplicationTest.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
@ActiveProfiles("junit")
public class AbstractSaveExampleTester {

    @Autowired
    private Example1Repository example1Repository;

    @Test
    public void saveExample1() {
        Example1 example1 = new Example1();
        example1.setTest1("Test");
        example1.setAbstractValue("Abstract Value");
        example1Repository.save(example1);
    }
}
