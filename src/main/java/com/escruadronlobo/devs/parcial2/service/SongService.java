package com.escruadronlobo.devs.parcial2.service;

import com.escruadronlobo.devs.parcial2.models.dtos.CreateSongDTO;
import com.escruadronlobo.devs.parcial2.models.dtos.SongDTO;

import java.util.List;
import java.util.UUID;

public interface SongService {
    List<SongDTO> getAllSongs(String search);

    SongDTO getSong(UUID code);

    SongDTO updateSong(UUID code, CreateSongDTO dto);

    SongDTO deleteSong(UUID code);

    SongDTO createSong(CreateSongDTO dto);

}
