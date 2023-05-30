package com.escruadronlobo.devs.parcial2.service.implementations;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escruadronlobo.devs.parcial2.models.dtos.UserDTO;
import com.escruadronlobo.devs.parcial2.models.entities.PlayList;
import com.escruadronlobo.devs.parcial2.models.entities.User;
import com.escruadronlobo.devs.parcial2.repositories.UserRepository;
import com.escruadronlobo.devs.parcial2.service.UserServiceInterface;

@Service
public class UserServiceImp implements UserServiceInterface{
	
	@Autowired
	private UserRepository userRepository;



	@Override
	public void save(UserDTO user) throws Exception {
		User newUser = new User(user.getUsername(), user.getEmail(), user.getPassword());
		userRepository.save(newUser);
	}


	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
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


	@Override
	public void update(String code, UserDTO user) throws Exception {
		UUID userID;
		
	    try {
	    	userID = UUID.fromString(code);
	    } catch (IllegalArgumentException e) {
	        throw new Exception("Invalid user code");
	    }

	    User existingUser = userRepository.findById(userID).orElse(null);
	    if (existingUser == null) {
	        throw new Exception("User not found");
	    }
	    
	    existingUser.setUsername(user.getUsername());
	    existingUser.setEmail(user.getEmail());
	    userRepository.save(existingUser);
		
	}


	@Override
	public List<User> findOneByUsername(String username) {
		return userRepository.findByUsernameContainingIgnoreCase(username);
	}


	@Override
	public void deleteOneById(String code) throws Exception {
		UUID id = UUID.fromString(code);
		userRepository.deleteById(id);
	}
}
