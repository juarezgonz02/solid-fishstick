package com.escruadronlobo.devs.parcial2.controllers;

import com.escruadronlobo.devs.parcial2.models.dtos.CreateSongDTO;
import com.escruadronlobo.devs.parcial2.models.dtos.SongDTO;
import com.escruadronlobo.devs.parcial2.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/songs")
public class SongsController {
	@Autowired
	SongService service;


	@GetMapping("/")
	public ResponseEntity<List<SongDTO>> getAllSongs(@RequestParam(value = "search", required = false) String search){
		try{
			return ResponseEntity.ok(service.getAllSongs(search));
		}
		catch (Exception exception){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/{code}")
	public ResponseEntity<?> getSong(@PathVariable("code") UUID code){
		try {
			return ResponseEntity.ok(service.getSong(code));
		}
		catch ( Exception exception ){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/")
	public ResponseEntity<?> addSong(@RequestBody CreateSongDTO dto){
		try{
			return ResponseEntity.ok(service.createSong(dto));
		}
		catch (Exception exception){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{code}")
	public ResponseEntity<?> editSong(@PathVariable("code") UUID code, @RequestBody CreateSongDTO dto){
		try{
			return ResponseEntity.ok(service.updateSong(code, dto));
		}
		catch (Exception exception){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{code}")
	public ResponseEntity<?> deleteSong(@PathVariable("code") UUID code){
		try {
			return ResponseEntity.ok(service.deleteSong(code));
		}
		catch (Exception exception){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}


}