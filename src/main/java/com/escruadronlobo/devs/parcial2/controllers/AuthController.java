package com.escruadronlobo.devs.parcial2.controllers;

import com.escruadronlobo.devs.parcial2.models.dtos.LoginDTO;
import com.escruadronlobo.devs.parcial2.models.dtos.RegisterDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    	public ResponseEntity<?> login(@RequestBody @Valid LoginDTO credentials, BindingResult result){

    		return new ResponseEntity<>(HttpStatus.OK);
    	}

	@PostMapping("/register")
		public ResponseEntity<?> register(@RequestParam @Valid RegisterDTO data, BindingResult result){

			return new ResponseEntity<>(HttpStatus.OK);
		}


}
