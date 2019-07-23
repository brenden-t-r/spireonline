package com.spireonline.app.config;

import com.spireonline.app.domain.BaseEntity;
import com.spireonline.app.repository.LoginHistoryRepository;
import com.spireonline.app.service.LoginHistoryService;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackageClasses = {BaseEntity.class})
@EnableJpaRepositories(basePackageClasses = {LoginHistoryRepository.class})
@ComponentScan(basePackageClasses = {LoginHistoryService.class})
public class PersistenceConfig
{
}
