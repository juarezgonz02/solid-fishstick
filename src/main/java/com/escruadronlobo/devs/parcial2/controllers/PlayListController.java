package com.escruadronlobo.devs.parcial2.controllers;

import com.escruadronlobo.devs.parcial2.models.entities.SongXPlaylist;
import com.escruadronlobo.devs.parcial2.repositories.PlayListRepository;
import com.escruadronlobo.devs.parcial2.service.SongXPlaylistServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/playlist")
public class PlayListController {

    @Autowired
    SongXPlaylistServiceInterface songXPlayListService ;

    @Autowired
    PlayListRepository playListRepository;

    @GetMapping("/songs")
    public ResponseEntity<?> getAllSongs(@RequestParam UUID playlist_id) throws Exception {

        List<SongXPlaylist> songs = songXPlayListService.findAllByPlayListCode(playlist_id);
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @PostMapping ("/songs/add")
    public ResponseEntity<?> addSongToPlaylist(@RequestParam UUID song_id, @RequestParam UUID playlist_id) {

        
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping("/songs/remove")
    	public ResponseEntity<?> removeSongFromPlaylist(@RequestParam UUID song_id, @RequestParam UUID playlist_id){


    		return new ResponseEntity<>(HttpStatus.OK);
    	}




    
    
}
