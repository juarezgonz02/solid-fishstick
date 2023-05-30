package com.escruadronlobo.devs.parcial2.service.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escruadronlobo.devs.parcial2.models.dtos.LoginDTO;
import com.escruadronlobo.devs.parcial2.models.entities.User;
import com.escruadronlobo.devs.parcial2.repositories.UserRepository;
import com.escruadronlobo.devs.parcial2.service.AuthService;

import jakarta.transaction.Transactional;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public void login(LoginDTO credentials) throws Exception {
		 String usernameOrEmail = credentials.getCredential();
	        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);

	        if (user == null) {
	            throw new Exception("Usuario no encontrado");
	        }

	        if (!credentials.getPassword().equals(user.getPassword())) {
	            throw new Exception("La contraseña es incorrecta");
	        }
	    }
}
