package com.escruadronlobo.devs.parcial2.service;

import com.escruadronlobo.devs.parcial2.models.dtos.LoginDTO;

public interface AuthService {
	void login(LoginDTO credentials) throws Exception;
}
