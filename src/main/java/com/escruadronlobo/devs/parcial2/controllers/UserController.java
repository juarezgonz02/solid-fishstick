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
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceInterface userService;
	
	@GetMapping("/all")
	public ResponseEntity<?> findAllUsers(){
		List<User> users = userService.findAll();
		return new ResponseEntity<>(
				users, HttpStatus.OK
				);
	}
	
	
	@GetMapping("/{code}")
	public ResponseEntity<?> findUserByCode(@PathVariable("code") String code){
		try {
	        User foundUser = userService.findOneById(code);
	        if (foundUser == null) {
	            return new ResponseEntity<>(new MessageDTO("User not found"), HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<>(foundUser, HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<>(new MessageDTO("Internal Server Error"), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@GetMapping("/search")
	public ResponseEntity<?> findOneUserByUsername(@RequestParam("username") String username){
		try {
            List<User> users = userService.findOneByUsername(username);
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	@DeleteMapping("/delete/{code}")
	public ResponseEntity<?> deleteUserByCode(@PathVariable("code") @Valid String code){
		try {
			User foundUser = userService.findOneById(code);
			if (foundUser == null) {
	            return new ResponseEntity<>(new MessageDTO("User not found"), HttpStatus.NOT_FOUND);
	        }
			
			userService.deleteOneById(code);
			return new ResponseEntity<>(new MessageDTO("User deleted"), HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
	        return new ResponseEntity<>(new MessageDTO("Internal Server Error"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{code}")
	public ResponseEntity<?> updatePlayList(@PathVariable("code") String code, @RequestBody UserDTO user) {
	    try {
	        User existingUser = userService.findOneById(code);
	        if (existingUser == null) {
	            return new ResponseEntity<>(new MessageDTO("User not found"), HttpStatus.NOT_FOUND);
	        }
	        existingUser.setUsername(user.getUsername());
	        existingUser.setEmail(user.getEmail());

	        userService.update(code, user);
	        return new ResponseEntity<>(new MessageDTO("User updated"), HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<>(new MessageDTO("Internal Server Error"), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}
