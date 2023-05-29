package com.escruadronlobo.devs.parcial2.service;

import com.escruadronlobo.devs.parcial2.models.entities.SongXPlaylist;

import java.util.List;
import java.util.UUID;

public interface SongXPlaylistServiceInterface {
    List<SongXPlaylist> findAllByPlayListCode(UUID playlist_code) throws Exception;
}
