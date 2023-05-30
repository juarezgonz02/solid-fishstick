package com.escruadronlobo.devs.parcial2.repositories;

import com.escruadronlobo.devs.parcial2.models.entities.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends ListCrudRepository<User, UUID> {
	List<User> findByUsernameContainingIgnoreCase(String username);
}
