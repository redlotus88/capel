package com.redlotus.security.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Login Controller
 *
 * @author Dragon.Wang
 */
@RestController
@Log4j2
public class LoginController {

    @PostMapping("/login")
    String login(@RequestParam String username) {
        return "Ok";
    }
}
