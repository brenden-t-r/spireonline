package com.spireonline.app.repository;

import com.spireonline.app.domain.user.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Long>
{
}
