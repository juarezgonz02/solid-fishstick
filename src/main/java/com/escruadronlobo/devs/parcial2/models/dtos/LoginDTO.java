package com.escruadronlobo.devs.parcial2.models.dtos;


import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
public class LoginDTO {
	
	public LoginDTO() {
        // Constructor predeterminado sin argumentos
    }

    @NonNull
    private String credential;

    @NonNull
    @Size(min = 8)
    private String password;
}
