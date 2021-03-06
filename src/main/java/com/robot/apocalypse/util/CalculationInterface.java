package com.robot.apocalypse.util;

import java.util.List;

import com.robot.apocalypse.model.Robot;
import com.robot.apocalypse.model.Survivor;

public interface CalculationInterface {
	
public List<Survivor> listOfInfectedSurvivors(List<Survivor> survivorList);
    
	public List<Survivor> listNonInfectedSurvivors(List<Survivor> survivorList);
    
	public String percentOfInfectedSurvivors(List<Survivor> survivorList);
    
    public String  percentOfNonInfectedSurvivors(List<Survivor> survivorList);
    
    public List<Robot> listOfRobots(List<Robot> robotList);
    

}
