package com.escruadronlobo.devs.parcial2.repositories;

import com.escruadronlobo.devs.parcial2.models.entities.Song;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.UUID;

public interface SongRepository extends ListCrudRepository<Song, UUID> {

    List<Song> findByTitleContainingIgnoreCase(String search);
}
