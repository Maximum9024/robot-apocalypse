package com.robot.apocalypse.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.robot.apocalypse.model.Robot;

@RestController
@RequestMapping("/robot/list")
public class RobotController {
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/robots")
	public List<Robot> getRobots() {
		
		String url ="https://robotstakeover20210903110417.azurewebsites.net/robotcpu";
		Robot[] robots = restTemplate.getForObject(url,Robot[].class);
		
		return Arrays.asList(robots);
	}

}
