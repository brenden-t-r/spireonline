package com.spireonline.app.service;

import com.spireonline.app.repository.LoginHistoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoginHistoryService
{
    private static final Logger LOG = LoggerFactory.getLogger(LoginHistoryService.class);

    private LoginHistoryRepository loginHistoryRepository;

    public LoginHistoryService(LoginHistoryRepository loginHistoryRepository)
    {
        this.loginHistoryRepository = loginHistoryRepository;
    }

}
