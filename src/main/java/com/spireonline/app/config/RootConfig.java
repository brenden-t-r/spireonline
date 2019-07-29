package com.spireonline.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {PersistenceConfig.class, ThreadConfig.class})
public class RootConfig
{
}
