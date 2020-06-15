package com.redlotus.user.controller;

import com.redlotus.security.common.CapelWebRequestPath;
import com.redlotus.user.builder.CapelUserBuilder;
import com.redlotus.user.service.CapelUserService;
import com.redlotus.user.vo.CapelUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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
    @PutMapping(CapelWebRequestPath.REGISTER)
    ResponseEntity<Boolean> register(@RequestBody @Valid CapelUserVO capelUserVO) {
        capelUserService.save(CapelUserBuilder.of(capelUserVO.getUsername(), capelUserVO.getPassword()).build());
        return ResponseEntity.of(Optional.of(Boolean.TRUE));
    }
}
