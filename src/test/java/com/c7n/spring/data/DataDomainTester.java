package com.c7n.spring.data;

import com.c7n.ApplicationTest;
import com.c7n.spring.data.dataDomain.bean.*;
import com.c7n.spring.data.dataDomain.repository.BizObjectRepo;
import com.c7n.spring.data.dataDomain.repository.KeyRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApplicationTest.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
@ActiveProfiles("junit")
public class DataDomainTester {

    @Autowired
    private KeyRepository keyRepository;

    @Autowired
    private BizObjectRepo bizObjectRepo;

    @Test
    public void testDoubleKeyDataDomain() {
        Key1 key1 = new Key1("SME", "23201", "MG");
        Key2 key2 = new Key2("MGZS5", "2020", "1230891290");
        DoubleKey<Key1, Key2> doubleKey = new DoubleKey<>();
        doubleKey.setKey1(key1);
        doubleKey.setKey2(key2);

        BizObjectDto dto = new BizObjectDto();
        dto.setKey(doubleKey);
        dto.setBizValue1("test biz 1");
        dto.setBizValue2("test biz 2");

        AbstractKey keyResult = keyRepository.save(key1);
        keyResult = keyRepository.save(key2);

        BizObject result = dto.toEntity();
        bizObjectRepo.save(result);
    }
}
