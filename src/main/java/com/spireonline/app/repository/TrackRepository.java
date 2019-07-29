package com.spireonline.app.repository;

import com.spireonline.app.domain.player.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long>
{

}
