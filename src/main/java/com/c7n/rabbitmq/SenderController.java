package com.c8n.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by dragon on 2019/8/7.
 */
@RestController
@RequestMapping("/rabbitmq")
@Slf4j
public class SenderController {

    @Autowired
    private FirstSender firstSender;

    @GetMapping("/send")
    public String send(@RequestParam String message) {
        log.info("Send message : {}", message);
        String uuid = UUID.randomUUID().toString();
        firstSender.send(uuid, message);
        return uuid;
    }
}
