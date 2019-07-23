package com.spireonline.app.config;

import com.spireonline.app.utils.DefaultEntityFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAutoConfiguration
@Import({PersistenceConfig.class})
public class RootTestConfig
{
    @Bean
    public DefaultEntityFactory defaultEntityFactory()
    {
        return new DefaultEntityFactory();
    }
}
