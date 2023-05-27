package com.escruadronlobo.devs.parcial2.repositories;

import com.escruadronlobo.devs.parcial2.models.entities.SongXPlaylist;
import org.aspectj.apache.bcel.util.Repository;
import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface SongXPlayListRepository extends ListCrudRepository<SongXPlaylist, UUID> {


}
