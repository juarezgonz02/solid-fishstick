package com.escruadronlobo.devs.parcial2.repositories;

import com.escruadronlobo.devs.parcial2.models.entities.PlayList;
import com.escruadronlobo.devs.parcial2.models.entities.Song;
import com.escruadronlobo.devs.parcial2.models.entities.SongXPlaylist;
import org.aspectj.apache.bcel.util.Repository;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.UUID;

public interface SongXPlayListRepository extends ListCrudRepository<SongXPlaylist, UUID> {

    Integer countSongXPlaylistByPlayListCode(PlayList playList_id );
    void deleteBySongCodeAndPlayListCode(Song songCode, PlayList playListCode);
}
