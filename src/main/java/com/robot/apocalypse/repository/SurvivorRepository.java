package com.robot.apocalypse.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.robot.apocalypse.model.Survivor;

@Repository
public interface SurvivorRepository extends CrudRepository<Survivor, String
> {
	//public Optional<Survivor> findById(String id);
	public Survivor findById(Long Id);

}
