package com.spireonline.app.repository;

import com.spireonline.app.domain.player.SpireProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpireProjectRepository extends JpaRepository<SpireProject, Long>
{
}
