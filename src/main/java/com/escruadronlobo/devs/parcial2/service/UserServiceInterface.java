package com.escruadronlobo.devs.parcial2.service;

import java.util.List;
import com.escruadronlobo.devs.parcial2.models.dtos.UserDTO;
import com.escruadronlobo.devs.parcial2.models.entities.User;

public interface UserServiceInterface {
	void save(UserDTO user) throws Exception;
	void update(String code, UserDTO user)throws Exception;
	void deleteOneById(String code) throws Exception;
	List<User> findAll();
	User findOneById(String code);
	List<User> findOneByUsername(String username);
}
