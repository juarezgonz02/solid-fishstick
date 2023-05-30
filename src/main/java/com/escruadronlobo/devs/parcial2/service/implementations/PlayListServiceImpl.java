package com.escruadronlobo.devs.parcial2.service.implementations;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escruadronlobo.devs.parcial2.models.dtos.PlayListDTO;
import com.escruadronlobo.devs.parcial2.models.entities.PlayList;
import com.escruadronlobo.devs.parcial2.models.entities.User;
import com.escruadronlobo.devs.parcial2.repositories.PlayListRepository;
import com.escruadronlobo.devs.parcial2.service.PlayListService;

import jakarta.transaction.Transactional;

@Service
public class PlayListServiceImpl implements PlayListService{
	
	@Autowired
	private PlayListRepository playListRepository;

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void save(PlayListDTO info, User user) throws Exception {
		PlayList newPlayList = new PlayList(info.getTitle(), info.getDescription(), user);
			playListRepository.save(newPlayList);
		
	}

	@Override
	@Transactional(rollbackOn = Exception.class)
	public void deleteOneById(String code) throws Exception {
		UUID id = UUID.fromString(code);
		playListRepository.deleteById(id);
		
	}

	@Override
	public List<PlayList> findAll() {
		return playListRepository.findAll();
	}

	@Override
	public PlayList findOneById(String code) {
		try {
			UUID id = UUID.fromString(code);
			return playListRepository.findById(id)
					.orElse(null);
		}catch (Exception e) {
			return null;
		}
	}
	

}
