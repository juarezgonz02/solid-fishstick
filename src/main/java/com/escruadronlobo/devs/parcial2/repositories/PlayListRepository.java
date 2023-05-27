package com.escruadronlobo.devs.parcial2.repositories;

import com.escruadronlobo.devs.parcial2.models.entities.PlayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface PlayListRepository extends ListCrudRepository<PlayList, UUID> {
}
