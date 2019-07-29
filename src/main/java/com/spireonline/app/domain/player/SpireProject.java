package com.spireonline.app.domain.player;

import com.spireonline.app.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table
public class SpireProject extends BaseEntity
{
    @Column
    private String name;

    @Column
    private Integer tempo;

    @OneToMany
    private List<Track> tracks;
}

