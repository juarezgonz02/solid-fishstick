package com.escruadronlobo.devs.parcial2.service;

import com.escruadronlobo.devs.parcial2.models.entities.User;

public interface UserServiceInterface {
	User findOneById(String code);
}
