package com.escruadronlobo.devs.parcial2.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserDTO {
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String email;
	
	@NotEmpty
	private String password;
}
