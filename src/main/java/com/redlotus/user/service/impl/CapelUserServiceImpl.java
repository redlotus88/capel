package com.redlotus.user.service.impl;

import com.redlotus.user.model.CapelUser;
import com.redlotus.user.repository.CapelUserRepository;
import com.redlotus.user.service.CapelUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CapelUserServiceImpl
 */
@Service
public class CapelUserServiceImpl implements CapelUserService {


    CapelUserRepository capelUserRepository;

    @Autowired
    public CapelUserServiceImpl(CapelUserRepository capelUserRepository) {
        this.capelUserRepository = capelUserRepository;
    }


    @Override
    public CapelUser save(CapelUser capelUser) {
        return capelUserRepository.save(capelUser);
    }
}
