package com.escruadronlobo.devs.parcial2.models.dtos;

import com.escruadronlobo.devs.parcial2.models.entities.Song;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class SongDTO {

    private UUID code;
    private String title;
    private String duration;

    public SongDTO(Song song){
        code = song.getCode();
        title = song.getTitle();
        duration = convertDurationToString(song.getDuration());
    }

    private String convertDurationToString(Integer duration) {
        int minutes = duration / 60;
        int seconds = duration % 60;

        return String.format("%s:%s", minutes, seconds);
    }
}
