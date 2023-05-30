package com.escruadronlobo.devs.parcial2.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.escruadronlobo.devs.parcial2.models.dtos.MessageDTO;
import com.escruadronlobo.devs.parcial2.models.dtos.PlayListDTO;
import com.escruadronlobo.devs.parcial2.models.entities.PlayList;
import com.escruadronlobo.devs.parcial2.models.entities.User;
import com.escruadronlobo.devs.parcial2.service.PlayListService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/playlist")
public class PlayListController {
	
	@Autowired 
	private PlayListService playListService;


	
	@GetMapping("/all")
	public ResponseEntity<?> findAllPlayLists(){
		List<PlayList> playLists = playListService.findAll();
		return new ResponseEntity<>(
					playLists, HttpStatus.OK
				);
	}
	
	@GetMapping("/search")
	public ResponseEntity<?> findOnePlayListByTitle(@RequestParam("title") String title){
		try {
            List<PlayList> playlists = playListService.findOneByTitle(title);
            return new ResponseEntity<>(playlists, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<?> findOnePlayListById(@PathVariable("code") String code){
		try {
	        PlayList foundPlaylist = playListService.findOneById(code);
	        if (foundPlaylist == null) {
	            return new ResponseEntity<>(new MessageDTO("Playlist not found"), HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<>(foundPlaylist, HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<>(new MessageDTO("Internal Server Error"), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> savePlayList(@RequestBody @Valid PlayListDTO info,  @RequestParam("usercode") User usercode){
		 try { 
		        playListService.save(info, usercode);
		        return new ResponseEntity<>(new MessageDTO("Playlist Created"), HttpStatus.CREATED);
		    } catch (Exception e) {
		        e.printStackTrace();
		        return new ResponseEntity<>(new MessageDTO("Internal Server Error"), HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		
	}
	
	@DeleteMapping("/delete/{code}")
	public ResponseEntity<?> deletePlayList(@PathVariable("code") String code) {
	    try {
	        PlayList playlist = playListService.findOneById(code);
	        if (playlist == null) {
	            return new ResponseEntity<>(new MessageDTO("Playlist not found"), HttpStatus.NOT_FOUND);
	        }
	        
	        playListService.deleteOneById(code);
	        return new ResponseEntity<>(new MessageDTO("Playlist deleted"), HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<>(new MessageDTO("Internal Server Error"), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@PutMapping("/update/{code}")
	public ResponseEntity<?> updatePlayList(@PathVariable("code") String code, @RequestBody PlayListDTO info) {
	    try {
	        PlayList existingPlaylist = playListService.findOneById(code);
	        if (existingPlaylist == null) {
	            return new ResponseEntity<>(new MessageDTO("Playlist not found"), HttpStatus.NOT_FOUND);
	        }
	        
	        existingPlaylist.setTitle(info.getTitle());
	        existingPlaylist.setDescription(info.getDescription());
	        
	        playListService.update(code, info);
	        return new ResponseEntity<>(new MessageDTO("Playlist updated"), HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<>(new MessageDTO("Internal Server Error"), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	
	
	
}
