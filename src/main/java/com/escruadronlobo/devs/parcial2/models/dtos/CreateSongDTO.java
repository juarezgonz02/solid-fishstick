package com.escruadronlobo.devs.parcial2.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateSongDTO {
    private String title;
    private Integer duration;
}
