package com.c7n.spring.data;

import com.c7n.ApplicationTest;
import com.c7n.spring.data.repository.ColumnAtGetterSetterExampleRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApplicationTest.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
@ActiveProfiles("junit")
public class SpringDataExampleTester {

    @Autowired
    private ColumnAtGetterSetterExampleRepository columnAtGetterSetterExampleRepository;

    @Test
    public void testColumnAtGetterSetterExample() {
        ColumnAtGetterSetterExample example = new ColumnAtGetterSetterExample(BigDecimal.TEN);
        example = columnAtGetterSetterExampleRepository.save(example);

        Optional<ColumnAtGetterSetterExample> example1 = columnAtGetterSetterExampleRepository.findById(example.getId());
        Assert.assertTrue(example1.isPresent());
    }
}
