package com.spireonline.app.utils;

import com.spireonline.app.domain.user.LoginHistory;
import com.spireonline.app.repository.LoginHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

/**
 * factory class to test repository functions
 */
@Component
public class DefaultEntityFactory
{
    public final static String TEST_STRING = "foobar";
    public final static LocalDate TEST_DATE = LocalDate.of(2001, 9, 11);
    public final static Integer TEST_INT = 42;
    public final static Long TEST_LONG = 42L;

    // Autowire all repositorieis per bean
    @Autowired
    private LoginHistoryRepository loginHistoryRepository;

    /**
     * create a #persist method that fills all neccessary attributes
     */
    public LoginHistory persistLoginHistory()
    {
        final LoginHistory loginHistory = new LoginHistory();
        loginHistory.setCount(TEST_LONG);
        loginHistory.setDate(TEST_DATE);

        return loginHistoryRepository.save(loginHistory);
    }

    @Transactional
    public void reset()
    {
        loginHistoryRepository.deleteAll();
    }
}
