package com.redlotus.user.service.impl;

import com.redlotus.user.model.CapelUser;
import com.redlotus.user.repository.CapelUserRepository;
import com.redlotus.user.service.CapelUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * CapelUserServiceImpl
 */
@Service
public class CapelUserServiceImpl implements CapelUserService {

    CapelUserRepository capelUserRepository;

    PasswordEncoder passwordEncoder;

    @Autowired
    public CapelUserServiceImpl(CapelUserRepository capelUserRepository, PasswordEncoder passwordEncoder) {
        this.capelUserRepository = capelUserRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public CapelUser save(CapelUser capelUser) {
        String encodedPassword = passwordEncoder.encode(capelUser.getPassword());
        return capelUserRepository.save(capelUser);
    }
}
