package com.ftn.sbnz.model.repositories;

import com.ftn.sbnz.model.models.Album;
import com.ftn.sbnz.model.models.Artist;
import com.ftn.sbnz.model.models.Song;
import com.ftn.sbnz.model.models.enums.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    Album getAlbumById(Long id);
    Album getAlbumByArtist(Artist artist);

}
