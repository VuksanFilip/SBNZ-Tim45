package com.ftn.sbnz.model.repositories;

import com.ftn.sbnz.model.models.Album;
import com.ftn.sbnz.model.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Artist getArtistById(Long id);
    Artist getArtistByUsername(String username);

}