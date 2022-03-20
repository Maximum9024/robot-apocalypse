package com.robot.apocalypse.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robot.apocalypse.model.Survivor;
import com.robot.apocalypse.repository.SurvivorRepository;
import com.robot.apocalypse.service.RegisterService;

@RestController
@RequestMapping(path="survivor/register")
public class RegisterController {
	
	@Autowired
	RegisterService registerService;
	@Autowired 
	SurvivorRepository survivorRepository;
	
	@PostMapping(value = "newSurvivor")
	public void registerSurvivor(@RequestBody Survivor newSurvivor) {
		registerService.registerNewSurvivor(newSurvivor);
	}
	
}
