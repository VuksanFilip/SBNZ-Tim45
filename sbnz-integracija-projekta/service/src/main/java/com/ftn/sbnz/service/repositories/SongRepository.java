package com.ftn.sbnz.service.repositories;

import com.ftn.sbnz.model.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    List<Song> findAll();
    List<Song> findAllByGenreId(Long genreId);
    List<Song> findAllByArtist_Id(Long artistId);

}