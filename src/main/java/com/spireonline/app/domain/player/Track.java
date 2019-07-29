package com.spireonline.app.domain.player;


import com.spireonline.app.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Track extends BaseEntity
{
    @ManyToOne
    private SpireProject spireProject;

    @NotNull
    @Column
    private String spireTrackId;



}
