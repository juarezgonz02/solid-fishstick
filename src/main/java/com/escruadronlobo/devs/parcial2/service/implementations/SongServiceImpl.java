package com.escruadronlobo.devs.parcial2.service.implementations;

import com.escruadronlobo.devs.parcial2.models.dtos.CreateSongDTO;
import com.escruadronlobo.devs.parcial2.models.dtos.SongDTO;
import com.escruadronlobo.devs.parcial2.models.entities.Song;
import com.escruadronlobo.devs.parcial2.repositories.SongRepository;
import com.escruadronlobo.devs.parcial2.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    SongRepository repository;

    @Override
    public List<SongDTO> getAllSongs(String search) {
        if (Optional.ofNullable(search).orElse("").isBlank()) {
            return repository.findAll().stream().map(SongDTO::new).collect(Collectors.toList());
        }

        return repository.findByTitleContainingIgnoreCase(search).stream().map(SongDTO::new).collect(Collectors.toList());
    }

    @Override
    public SongDTO getSong(UUID code) {
        Song song = repository.findById(code).orElseThrow(() -> new RuntimeException("Song was not found"));
        return new SongDTO(song);
    }

    private void updateSong(Song song, CreateSongDTO dto){
        song.setDuration(dto.getDuration());
        song.setTitle(dto.getTitle());
    }

    @Override
    public SongDTO updateSong(UUID code, CreateSongDTO dto) {
        Song song = repository.findById(code).orElseThrow(() -> new RuntimeException("Song was not found"));

        updateSong(song, dto);
        return new SongDTO(repository.save(song));
    }

    @Override
    public SongDTO deleteSong(UUID code) {
        Song song = repository.findById(code).orElseThrow(() -> new RuntimeException("Song was not found"));
        repository.delete(song);

        return new SongDTO(song);
    }

    @Override
    public SongDTO createSong(CreateSongDTO dto) {
        Song song = new Song(dto.getTitle(), dto.getDuration());
        return new SongDTO(repository.save(song));
    }
}
