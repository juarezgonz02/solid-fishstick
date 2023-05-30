package com.escruadronlobo.devs.parcial2.service.implementations;

import com.escruadronlobo.devs.parcial2.models.entities.PlayList;
import com.escruadronlobo.devs.parcial2.models.entities.Song;
import com.escruadronlobo.devs.parcial2.models.entities.SongXPlaylist;
import com.escruadronlobo.devs.parcial2.repositories.PlayListRepository;
import com.escruadronlobo.devs.parcial2.repositories.SongRepository;
import com.escruadronlobo.devs.parcial2.repositories.SongXPlayListRepository;
import com.escruadronlobo.devs.parcial2.service.SongXPlaylistServiceInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SongXPlaylistServiceImp implements SongXPlaylistServiceInterface {

    @Autowired
    SongXPlayListRepository songXPlayListRepository;

    @Autowired
    PlayListRepository playListRepository;

    @Autowired
    SongRepository songRepository;


    @Override
    public List<Song> findAllSongsInPlaylist(UUID playlist_code) {

        Optional<PlayList> playListInfo = playListRepository.findById(playlist_code);

        if(playListInfo.isEmpty()){
            return null;
        }

        List<SongXPlaylist> playlist = playListInfo.get().getSongsInPlaylist();

        List<Song> songs = playlist.stream().map(SongXPlaylist::getSongCode).collect(Collectors.toList());

        return songs;
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void addSongToPlaylist(UUID songId, UUID playlistId) {
        Optional<Song> sonfInfo = songRepository.findById(songId);
        Optional<PlayList> playListInfo = playListRepository.findById(playlistId);

        if(playListInfo.isPresent() && sonfInfo.isPresent()){
             SongXPlaylist songANDplaylist = new SongXPlaylist(playListInfo.get(), sonfInfo.get(), Calendar.getInstance().getTime());

             songXPlayListRepository.save(songANDplaylist);
        }

    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void deleteSongFromPlaylist(UUID songId, UUID playlistId) {
        Optional<Song> sonfInfo = songRepository.findById(songId);
        Optional<PlayList> playListInfo = playListRepository.findById(playlistId);

        if(playListInfo.isPresent() && sonfInfo.isPresent()){
            songXPlayListRepository.deleteBySongCodeAndPlayListCode(sonfInfo.get(), playListInfo.get());
        }
    }

    @Override
    public int countSongOnPlaylist(UUID playlistId) {

        Optional<PlayList> playListInfo = playListRepository.findById(playlistId);
        if(playListInfo.isEmpty()){
            return -1;
        }

        return songXPlayListRepository.countSongXPlaylistByPlayListCode(playListInfo.get());
    }

    @Override
    public List<PlayList> filterPlaylistByDuration(UUID playlist_id, int duration) {
        return null;
    }

    @Override
    public List<Song> getSongsOrderedAsc(UUID playlistId) {
        return null;
    }

    @Override
    public List<Song> getSongsOrderedDesc(UUID playlistId) {
        return null;
    }
}
