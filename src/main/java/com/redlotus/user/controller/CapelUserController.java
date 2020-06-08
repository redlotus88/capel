package com.redlotus.user.controller;

import com.redlotus.security.common.CapelWebRequestPath;
import com.redlotus.user.builder.CapelUserBuilder;
import com.redlotus.user.service.CapelUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * 用户控制器
 */
@RestController
public class CapelUserController {

    CapelUserService capelUserService;

    @Autowired
    public CapelUserController(CapelUserService capelUserService) {
        this.capelUserService = capelUserService;
    }

    /**
     * 用户注册
     * @return Boolean
     */
    @PutMapping(CapelWebRequestPath.USER_REGISTER)
    ResponseEntity<Boolean> register() {
        capelUserService.save(CapelUserBuilder.of("test", "test").build());
        return ResponseEntity.of(Optional.of(Boolean.TRUE));
    }
}
