package com.ftn.sbnz.service.services.impl;

import com.ftn.sbnz.model.models.Song;
import com.ftn.sbnz.model.models.dtos.SongDTO;
import com.ftn.sbnz.service.exceptions.NotFoundException;
import com.ftn.sbnz.service.repositories.SongRepository;
import com.ftn.sbnz.service.services.SongService;
import com.ftn.sbnz.service.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;

    private final UserService userService;

    @Override
    public Song findById(Long id) {
        return songRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Song with id %s not found!", id)));
    }

//    @Override
//    public String addToFavoriteSongs(Long userId, Long songId) {
//        User user = userService.findById(userId);
//        List<Song> favoriteSongs = user.getFavoriteSongs();
//
//        Song song = findById(songId);
//
//        for (Song favoriteSong : favoriteSongs) {
//            if (favoriteSong.getId().equals(songId)){
//                throw new BadRequestException(String.format("Song %s by %s is already in your favorites!", song.getName(), song.getArtist().getUsername()));
//            }
//        }
//
//        favoriteSongs.add(song);
//        user.setFavoriteSongs(favoriteSongs);
//        userService.save(user);
//
//        return String.format("Successfully added song %s by %s to user %s's favorites songs!", song.getName(), song.getArtist().getUsername(), user.getUsername());
//    }
//
//    @Override
//    public String addToListenedSongs(Long userId, Long songId) {
//        User user = userService.findById(userId);
//        List<Song> listenedSongs = user.getFavoriteSongs();
//
//        Song song = findById(songId);
//
//        boolean alreadyListened = false;
//
//        for (Song listenedSong : listenedSongs) {
//            if (listenedSong.getId().equals(songId)){
//                alreadyListened = true;
//            }
//        }
//
//        if (alreadyListened) {
//            listenedSongs.add(song);
//            user.setListenedSongs(listenedSongs);
//            userService.save(user);
//        }
//
//        return String.format("Successfully listened song %s by %s!", song.getName(), song.getArtist().getUsername());
//    }



    @Override
    public List<SongDTO> findAll() {
        return songRepository.findAll().stream()
                .map(SongDTO::toSongDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<SongDTO> findAllByArtist(Long artistId) {
        return songRepository.findAllByArtist_Id(artistId).stream()
                .map(SongDTO::toSongDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<SongDTO> findAllByGenre(Long genreId) {
        return songRepository.findAllByArtist_Id(genreId).stream()
                .map(SongDTO::toSongDTO)
                .collect(Collectors.toList());
    }



}
