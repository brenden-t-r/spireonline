package com.spireonline.app.service;

import com.spireonline.app.repository.SpireProjectRepository;
import com.spireonline.app.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpireProjectService
{
    private SpireProjectRepository spireProjectRepository;
    private TrackRepository trackRepository;


    @Autowired
    public SpireProjectService(SpireProjectRepository spireProjectRepository, TrackRepository trackRepository)
    {
        this.spireProjectRepository = spireProjectRepository;
        this.trackRepository = trackRepository;
    }
}
