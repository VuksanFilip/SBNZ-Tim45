package com.ftn.sbnz.service.services;

import java.util.Set;

public interface FactsService {

    Set<String> findArtistFacts(Long id);

    Set<String> findAlbumFacts(Long id);

    Set<String> findSongFacts(Long songId);

}
