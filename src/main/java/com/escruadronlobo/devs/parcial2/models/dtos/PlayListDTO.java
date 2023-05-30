package com.escruadronlobo.devs.parcial2.models.dtos;

import java.util.UUID;

import com.escruadronlobo.devs.parcial2.models.entities.User;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class PlayListDTO {
	
	@NotEmpty
	private String title;
	
	@NotEmpty
	private String description;
	
	@NotEmpty
	private UUID usercode;
	
}
