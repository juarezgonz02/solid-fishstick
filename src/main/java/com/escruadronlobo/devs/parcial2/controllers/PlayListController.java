package com.escruadronlobo.devs.parcial2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escruadronlobo.devs.parcial2.models.entities.PlayList;
import com.escruadronlobo.devs.parcial2.service.PlayListService;

@RestController
@RequestMapping("/playlist")
public class PlayListController {
	
	@Autowired 
	private PlayListService playListService;
	
	@GetMapping("/")
	public ResponseEntity<?> findAllPlayLists(){
		List<PlayList> playLists = playListService.findAll();
		return new ResponseEntity<>(
					playLists, HttpStatus.OK
				);
	}
	
}
