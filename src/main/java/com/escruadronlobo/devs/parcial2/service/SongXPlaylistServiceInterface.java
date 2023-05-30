package com.escruadronlobo.devs.parcial2.service;

import com.escruadronlobo.devs.parcial2.models.entities.PlayList;
import com.escruadronlobo.devs.parcial2.models.entities.Song;

import java.util.List;
import java.util.UUID;

public interface SongXPlaylistServiceInterface {
    List<Song> findAllSongsInPlaylist(UUID playlist_code) throws Exception;

    void addSongToPlaylist(UUID songId, UUID playlistId);

    void deleteSongFromPlaylist(UUID songId, UUID playlistId);

    int countSongOnPlaylist(UUID playlistId);

    List<PlayList> filterPlaylistByDuration(UUID playlist_id, int duration);

    List<Song> getSongsOrderedAsc(UUID playlistId);

    List<Song> getSongsOrderedDesc(UUID playlistId);
}
