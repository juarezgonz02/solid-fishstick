package com.escruadronlobo.devs.parcial2.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class PlayListDTO {
	
	@NotEmpty
	private String title;
	
	@NotEmpty
	private String description;
	
}
