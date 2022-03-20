package com.robot.apocalypse.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.robot.apocalypse.service.FlagService;

@RestController
@RequestMapping(path="survivor/flag")
public class FlagController {
	
	@Autowired
	private FlagService flagService;
	
	@PutMapping("{survivorId}")
	public void flagSurvivor(@PathVariable Long survivorId) {
	flagService.flagSurvivor(survivorId);
	}
	
}
