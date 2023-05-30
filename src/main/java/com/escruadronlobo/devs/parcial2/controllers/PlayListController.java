package com.escruadronlobo.devs.parcial2.controllers;

import com.escruadronlobo.devs.parcial2.models.entities.PlayList;
import com.escruadronlobo.devs.parcial2.models.entities.Song;
import com.escruadronlobo.devs.parcial2.models.entities.SongXPlaylist;
import com.escruadronlobo.devs.parcial2.repositories.PlayListRepository;
import com.escruadronlobo.devs.parcial2.repositories.SongRepository;
import com.escruadronlobo.devs.parcial2.repositories.UserRepository;
import com.escruadronlobo.devs.parcial2.service.SongXPlaylistServiceInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/playlist")
public class PlayListController {

    @Autowired
    SongXPlaylistServiceInterface songXPlayListService ;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SongRepository songRepository;

    @GetMapping("/songs")
    public ResponseEntity<?> getAllSongs(@RequestParam UUID playlist_id) throws Exception {

        List<Song> songs = songXPlayListService.findAllSongsInPlaylist(playlist_id);
        //System.out.println(songs);

        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @PostMapping ("/songs/add")
    public ResponseEntity<?> addSongToPlaylist(@RequestParam UUID song_id, @RequestParam UUID playlist_id) {

        songXPlayListService.addSongToPlaylist(song_id, playlist_id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping("/songs/remove")
    	public ResponseEntity<?> removeSongFromPlaylist(@RequestParam UUID song_id, @RequestParam UUID playlist_id){


        songXPlayListService.deleteSongFromPlaylist(song_id, playlist_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/songs/count")
    public ResponseEntity<?> countSongsInPlaylist(@RequestParam UUID playlist_id) {

        Map<String, Integer> messages = new HashMap<>();

        int songCount = songXPlayListService.countSongOnPlaylist(playlist_id);

        messages.put("Songs in Playlist", songCount);

        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @GetMapping("/songs/filterByPlaylistDuration")
    public ResponseEntity<?> filterByPlaylistDuration(@RequestParam UUID playlist_id, @RequestParam int duration) {

        List<PlayList> filteredSongs = songXPlayListService.filterPlaylistByDuration(playlist_id, duration);
        return new ResponseEntity<>(filteredSongs, HttpStatus.OK);
    }
    @GetMapping("/songs/orderByAsc")
    public ResponseEntity<?> orderSongsByAsc(@RequestParam UUID playlist_id) {

        List<Song> orderedSongs = songXPlayListService.getSongsOrderedAsc(playlist_id);
        return new ResponseEntity<>(orderedSongs, HttpStatus.OK);
    }

    @GetMapping("/songs/orderByDesc")
    public ResponseEntity<?> orderSongsByDesc(@RequestParam UUID playlist_id) {

        List<Song> orderedSongs = songXPlayListService.getSongsOrderedDesc(playlist_id);

        return new ResponseEntity<>(orderedSongs, HttpStatus.OK);
    }

    
}
