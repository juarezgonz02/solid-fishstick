package com.escruadronlobo.devs.parcial2.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class PlayListDTO {
	
	@NotEmpty(message = "title is required")
	private String title;
	
	@NotEmpty(message = "description is required")
	private String description;
	
}
