package com.escruadronlobo.devs.parcial2.models.dtos;

import lombok.Data;
import lombok.NonNull;

@Data
public class RegisterDTO {
    @NonNull
    private String username;

    @NonNull
    private String email;

    @NonNull
    private String password;
}
