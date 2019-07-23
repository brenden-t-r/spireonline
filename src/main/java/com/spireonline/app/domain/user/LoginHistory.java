package com.spireonline.app.domain.user;

import com.spireonline.app.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "LOGIN_HISTORY")
public class LoginHistory extends BaseEntity
{
    @Column(name = "history_date")
    private LocalDate date;

    private Long count = 0L;

    public LoginHistory() {
    }

    public LoginHistory(LocalDate date, Long count) {
        this.date = date;
        this.count = count;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
