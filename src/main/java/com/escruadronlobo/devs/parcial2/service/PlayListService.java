package com.escruadronlobo.devs.parcial2.service;

import java.util.List;

import com.escruadronlobo.devs.parcial2.models.dtos.PlayListDTO;
import com.escruadronlobo.devs.parcial2.models.entities.PlayList;
import com.escruadronlobo.devs.parcial2.models.entities.User;

public interface PlayListService {
	void save(PlayListDTO info, User usercode) throws Exception;
	void deleteOneById(String code) throws Exception;
	List<PlayList> findAll();
	PlayList findOneById(String code);
}
