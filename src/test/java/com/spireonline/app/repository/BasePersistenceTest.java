package com.spireonline.app.repository;

import com.spireonline.app.config.RootTestConfig;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = { RootTestConfig.class })
public abstract class BasePersistenceTest
{
}
