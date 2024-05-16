package com.ftn.sbnz.service.repositories;

import com.ftn.sbnz.model.models.Album;
import com.ftn.sbnz.model.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

    Album getAlbumById(Long id);

    Album getAlbumByArtist(Artist artist);

}
