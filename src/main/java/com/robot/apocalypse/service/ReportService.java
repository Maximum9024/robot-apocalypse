package com.robot.apocalypse.service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.robot.apocalypse.model.Robot;
import com.robot.apocalypse.model.Survivor;
import com.robot.apocalypse.model.SurvivorList;
import com.robot.apocalypse.repository.SurvivorRepository;
import com.robot.apocalypse.util.CalculationUtil;
import com.robot.apocalypse.util.ReportUtil;
import com.robot.apocalypse.util.SortUtil;

import net.sf.jasperreports.engine.JRException;

@Service
public class ReportService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private SurvivorRepository survivorRepository;

	private static final String URL = "https://robotstakeover20210903110417.azurewebsites.net/robotcpu";
	private static final String SOURCEFILE_ROBOT_LIST = "src/main/resources/reports/ApocalypseReport.jrxml";
	private static final String SOURCEFILE_SURVIVOR_LIST = "src/main/resources/reports/ApocalypseReport.jrxml";

	public List<Robot> getRobots() {
		Robot[] robots = restTemplate.getForObject(URL, Robot[].class);
		
		return SortUtil.sortRobotList(Arrays.asList(robots));
	}

	public byte[] robotListPDFReport() throws FileNotFoundException, JRException {

		HashMap<String, Object> map = new HashMap<String, Object>();
		byte[] generateReport = ReportUtil.generatePDFReport(getRobots(), SOURCEFILE_ROBOT_LIST, map);

		return generateReport;
	}

	// survivor report
	public byte[] survivorListPDFReport() throws FileNotFoundException, JRException {
		CalculationUtil calculationUtil = new CalculationUtil();
		List<Survivor> survivors = (List<Survivor>) survivorRepository.findAll();
		String percentOfInfectedSurvivors = Double.toString(calculationUtil.percentOfInfectedSurvivors(survivors));
		String percentOfNonInfectedSurvivors =Double.toString( calculationUtil.percentOfNonInfectedSurvivors(survivors));
		List<Survivor> listOfInfectedSurvivors = calculationUtil.listOfInfectedSurvivors(survivors);
		List<Survivor> listOfNonInfectedSurvivors = calculationUtil.listNonInfectedSurvivors(survivors);

		HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("percentOfInfectedSurvivors", percentOfInfectedSurvivors);
        map.put("percentOfNonInfectedSurvivors", percentOfNonInfectedSurvivors);

        List<SurvivorList> survivorLists= new ArrayList<SurvivorList>();
        survivorLists.add(new SurvivorList());
        survivorLists.get(0).setNonInfected(listOfNonInfectedSurvivors);
        survivorLists.get(0).setInfected(listOfInfectedSurvivors);
                       
		byte[] generateReport = ReportUtil.generatePDFReport(survivorLists, SOURCEFILE_SURVIVOR_LIST, map);

		return generateReport;
	}
	
}
