package com.spireonline.app.repository;

import com.spireonline.app.domain.user.LoginHistory;
import com.spireonline.app.utils.DefaultEntityFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Collections;

public class LoginHistoryRepositoryTest extends AbstractRepositoryTest<LoginHistory>
{
    @Autowired
    private DefaultEntityFactory defaultEntityFactory;

    @Autowired
    private LoginHistoryRepository loginHistoryRepository;

    @Override
    protected Collection<LoginHistory> getPersistedEntities()
    {
        return Collections.singleton(defaultEntityFactory.persistLoginHistory());
    }

    @Override
    protected JpaRepository<LoginHistory, Long> getRepository()
    {
        return loginHistoryRepository;
    }
}
