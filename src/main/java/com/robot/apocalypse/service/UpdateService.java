package com.robot.apocalypse.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robot.apocalypse.model.Survivor;
import com.robot.apocalypse.repository.SurvivorRepository;

@Service
public class UpdateService {
	@Autowired
	private SurvivorRepository survivorRepository;
	
	public Survivor updateSurvivor(Long survivorId, Survivor updateSurvivor) {
		
	Survivor survivor=survivorRepository.findById(survivorId);
			                 
	if(survivor!=null) {
		survivor.setLastLocation(updateSurvivor.getLastLocation());
		survivorRepository.save(survivor);
	}
	
		return survivor;
	}
	
	
}
