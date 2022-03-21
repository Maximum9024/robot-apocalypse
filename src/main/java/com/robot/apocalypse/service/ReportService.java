package com.robot.apocalypse.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.robot.apocalypse.model.Robot;
import com.robot.apocalypse.repository.SurvivorRepository;
import com.robot.apocalypse.util.ReportUtil;

import net.sf.jasperreports.engine.JRException;

@Service
public class ReportService {
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private SurvivorRepository survivorRepository;
	
	private static String url ="https://robotstakeover20210903110417.azurewebsites.net/robotcpu";
	private static String sourceFile ="src/main/resources/reports/Apocalypse.jrxml";
	
	public List<Robot> getRobots() {
		Robot[] robots = restTemplate.getForObject(url,Robot[].class);
		Arrays.sort(robots);
		return Arrays.asList(robots);
	}
	
	
	public byte[] generatePDFReport() throws FileNotFoundException, JRException {
		ReportUtil reportUtil= new ReportUtil();
		byte[] generateReport =reportUtil.generatePDFReport(getRobots(),sourceFile);		
	
		return generateReport ;
	}
	
}
