package com.ftn.sbnz.service.repositories;

import com.ftn.sbnz.model.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    Song getSongById(Long id);

    Song getSongByName(String name);

}