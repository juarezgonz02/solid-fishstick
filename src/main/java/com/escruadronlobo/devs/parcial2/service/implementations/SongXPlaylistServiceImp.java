package com.escruadronlobo.devs.parcial2.service.implementations;

import com.escruadronlobo.devs.parcial2.models.entities.PlayList;
import com.escruadronlobo.devs.parcial2.models.entities.SongXPlaylist;
import com.escruadronlobo.devs.parcial2.repositories.PlayListRepository;
import com.escruadronlobo.devs.parcial2.repositories.SongXPlayListRepository;
import com.escruadronlobo.devs.parcial2.service.SongXPlaylistServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SongXPlaylistServiceImp implements SongXPlaylistServiceInterface {

    @Autowired
    SongXPlayListRepository songXPlayListRepository;

    @Autowired
    PlayListRepository playListRepository;

    @Override
    public List<SongXPlaylist> findAllByPlayListCode(UUID playlist_code) {
        PlayList playlist = playListRepository.findById(playlist_code).orElse(null);

        return songXPlayListRepository.findAllByPlayListCode(playlist);

    }
}
