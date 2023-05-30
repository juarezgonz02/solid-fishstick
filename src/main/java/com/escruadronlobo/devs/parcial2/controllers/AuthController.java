package com.escruadronlobo.devs.parcial2.controllers;

import com.escruadronlobo.devs.parcial2.models.dtos.LoginDTO;
import com.escruadronlobo.devs.parcial2.models.dtos.MessageDTO;
import com.escruadronlobo.devs.parcial2.models.dtos.RegisterDTO;
import com.escruadronlobo.devs.parcial2.models.dtos.UserDTO;
import com.escruadronlobo.devs.parcial2.service.AuthService;
import com.escruadronlobo.devs.parcial2.service.UserServiceInterface;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private UserServiceInterface userService;

    @PostMapping("/login")
    	public ResponseEntity<?> login(@RequestBody @Valid LoginDTO credentials, BindingResult result){
        try {
            authService.login(credentials);
            return new ResponseEntity<>(new MessageDTO("Successful login"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageDTO(e.getMessage()), HttpStatus.UNAUTHORIZED);
        }
    }
    
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody @Valid UserDTO user){
		try { 
	        userService.save(user);
	        return new ResponseEntity<>(new MessageDTO("User Created"), HttpStatus.CREATED);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<>(new MessageDTO("Internal Server Error"), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
   

}
