package com.robot.apocalypse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robot.apocalypse.model.Location;
import com.robot.apocalypse.model.Survivor;
import com.robot.apocalypse.repository.LocationRepository;
import com.robot.apocalypse.repository.SurvivorRepository;

@Service
public class RegisterService {
	
	@Autowired
	private SurvivorRepository survivorRepository;
	
	@Autowired
	private LocationRepository locationRepository;
	
	public Survivor registerNewSurvivor(Survivor newSurvivor) {
		Survivor survivor= new Survivor();
		Location location = newSurvivor.getLastLocation();
		
		survivor.setId(newSurvivor.getId());
		survivor.setName(newSurvivor.getName());
		survivor.setAge(newSurvivor.getAge());
		survivor.setGender(newSurvivor.getGender());
		survivor.setInventory(newSurvivor.getInventory());
		survivor.setLastLocation(location);
		
		locationRepository.save(location);
		survivorRepository.save(survivor);
		System.out.println(newSurvivor);
		
		return newSurvivor;
	}
	

}
