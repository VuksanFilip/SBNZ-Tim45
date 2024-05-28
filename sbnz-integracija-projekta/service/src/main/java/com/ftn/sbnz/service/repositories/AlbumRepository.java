package com.ftn.sbnz.service.repositories;

import com.ftn.sbnz.model.models.Album;
import com.ftn.sbnz.model.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

    @Query("SELECT a FROM Album a JOIN a.songs s WHERE s.id = :songId")
    Optional<Album> findBySongId(@Param("songId") Long songId);

    Optional<Album> findByArtistId(Long artistId);

    List<Album> findAll();
}
