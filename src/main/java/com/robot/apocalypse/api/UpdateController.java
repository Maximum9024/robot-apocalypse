package com.robot.apocalypse.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robot.apocalypse.model.Location;
import com.robot.apocalypse.model.Survivor;
import com.robot.apocalypse.service.UpdateService;

@RestController
@RequestMapping(path="survivor/update")
public class UpdateController {
	
	@Autowired
	UpdateService updateService;
	
	@PutMapping(path="{survivorId}")
	public void updateSurvivor(@PathVariable("survivorId") Long Id,@RequestBody Survivor location) {
		updateService.updateSurvivor(Id,location);
		
	}

}
