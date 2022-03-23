package com.robot.apocalypse.util;

import java.util.ArrayList;
import java.util.List;

import com.robot.apocalypse.model.Robot;
import com.robot.apocalypse.model.Survivor;

public final class CalculationUtil implements CalculationInterface {
	
	

	@Override
	public List<Survivor> listOfInfectedSurvivors(List<Survivor> survivorList) {
	
		List<Survivor> infectedSurvivors = new ArrayList<Survivor>();
		
		for(Survivor survivor : survivorList) {
		
			if(survivor.isFlag()) {
				infectedSurvivors.add(survivor);
			}
		}
		
		return infectedSurvivors;
	}

	@Override
	public List<Survivor> listNonInfectedSurvivors(List<Survivor> survivorList) {
		
		List<Survivor> nonInfectedSurvivors = new ArrayList<Survivor>();
		
		for(Survivor survivor : survivorList) {
			
			//non infected survivors
			if(!survivor.isFlag()) {
				nonInfectedSurvivors.add(survivor);
			}
		}
		
		return nonInfectedSurvivors;
	}

	@Override
	public String percentOfInfectedSurvivors(List<Survivor> survivorList) {
		  double percentOfInfectedSurvivors=0;
		  List<Survivor> infectedSurvivors = new ArrayList<Survivor>();
		  for(Survivor survivor : survivorList) {
				
				if(survivor.isFlag()) {
					infectedSurvivors.add(survivor);
				}
			}
		   
		     double infected=infectedSurvivors.size();
		     double survivors=survivorList.size();
		  percentOfInfectedSurvivors= (infected/survivors)*100;
		  
		  
		return String.format("%.2f", percentOfInfectedSurvivors) +" %";
	}

	@Override
	public String  percentOfNonInfectedSurvivors(List<Survivor> survivorList) {
		 double percentOfNonInfectedSurvivors=0;
		 List<Survivor> nonInfectedSurvivors = new ArrayList<Survivor>();
		 for(Survivor survivor : survivorList) {
				
				//percent of non infected survivors
				if(!survivor.isFlag()) {
					nonInfectedSurvivors.add(survivor);
				}
			}
		 double nonInfected=nonInfectedSurvivors.size();
	     double survivors=survivorList.size();
			
		 percentOfNonInfectedSurvivors= (nonInfected/survivors)*100;
		return String.format("%.2f",percentOfNonInfectedSurvivors)+" %";
	}

	@Override
	public List<Robot> listOfRobots(List<Robot> robotList) {
	
		return robotList;
	}
	
	
	
    
    
}
