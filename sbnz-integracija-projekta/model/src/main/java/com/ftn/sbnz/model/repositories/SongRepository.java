package com.ftn.sbnz.model.repositories;

import com.ftn.sbnz.model.models.Album;
import com.ftn.sbnz.model.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    Album getAlbumById(Long id);
    Album getAlbumByName(String name);

}