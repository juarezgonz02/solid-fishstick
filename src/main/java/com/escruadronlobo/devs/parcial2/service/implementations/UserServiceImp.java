package com.escruadronlobo.devs.parcial2.service.implementations;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import com.escruadronlobo.devs.parcial2.models.entities.User;
import com.escruadronlobo.devs.parcial2.repositories.UserRepository;
import com.escruadronlobo.devs.parcial2.service.UserServiceInterface;

public class UserServiceImp implements UserServiceInterface{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findOneById(String code) {
		try {
			UUID id = UUID.fromString(code);
			return userRepository.findById(id)
					.orElse(null);
		}catch (Exception e) {
			return null;
		}
	}
}
