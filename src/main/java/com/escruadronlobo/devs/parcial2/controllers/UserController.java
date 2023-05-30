package com.escruadronlobo.devs.parcial2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.escruadronlobo.devs.parcial2.models.dtos.MessageDTO;
import com.escruadronlobo.devs.parcial2.models.dtos.PlayListDTO;
import com.escruadronlobo.devs.parcial2.models.dtos.UserDTO;
import com.escruadronlobo.devs.parcial2.models.entities.PlayList;
import com.escruadronlobo.devs.parcial2.models.entities.User;
import com.escruadronlobo.devs.parcial2.service.UserServiceInterface;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{code}")
	public User getUserByCode(@PathVariable UUID code) {
		return userService.getUserByCode(code);
	}

	@PostMapping
	public void createUser(@RequestBody User user) {
		userService.createUser(user);
	}

	@PutMapping("/{code}")
	public void updateUser(@PathVariable UUID code, @RequestBody User user) {
		userService.updateUser(code, user);
	}

	@DeleteMapping("/{code}")
	public void deleteUser(@PathVariable UUID code) {
		userService.deleteUser(code);
	}
}
