package com.c8n.springEvent;

import com.c8n.springEvent.bean.SpringEventBean;
import com.c8n.springEvent.bean.SpringEventTransactionalExample;
import com.c8n.springEvent.repository.SpringEventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 * Created by dragon on 2020/1/21.
 */
@Service
@Slf4j
public class SpringEventServiceImpl implements SpringEventService {

    @Autowired
    private SpringEventRepository springEventRepository;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    @Transactional
    public void doATransaction() {
        log.info("Spring Event Do a Transaction");
        SpringEventBean seb = new SpringEventBean();
        seb.setName("Test Name");
        seb.setDesc("Test Desc");
        springEventRepository.save(seb);
        log.info("{}", seb);
    }

    @Override
    @Transactional
    public void doAFailedTransaction() {
        log.info("Spring Event Do a failed Transaction");
        SpringEventBean seb = new SpringEventBean();
        seb.setName("Failed Transaction " + Integer.toString(new Random().nextInt(100)));
        seb.setDesc("Test Desc");
        seb = springEventRepository.save(seb);

        SpringEventTransactionalExample sete = new SpringEventTransactionalExample(this, "failed");
        applicationContext.publishEvent(sete);
    }

}
