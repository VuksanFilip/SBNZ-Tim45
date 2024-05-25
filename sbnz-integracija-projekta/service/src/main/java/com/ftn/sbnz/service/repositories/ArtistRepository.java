package com.ftn.sbnz.service.repositories;

import com.ftn.sbnz.model.models.Artist;
import com.ftn.sbnz.model.models.Song;
import com.ftn.sbnz.model.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

    List<Artist> findAll();

    @Query("SELECT a FROM Artist a JOIN a.songs s WHERE s.id = :songId")
    Optional<Artist> findBySongId(@Param("songId") Long songId);

    Optional<Artist> findByGenre_Id(Long genreId);
}