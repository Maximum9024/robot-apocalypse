package com.robot.apocalypse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robot.apocalypse.model.Survivor;
import com.robot.apocalypse.repository.SurvivorRepository;

@Service
public class FlagService {
	
	@Autowired 
	private SurvivorRepository survivorRepository;
	
	public Survivor flagSurvivor(Long survivorID) {
		
		Survivor survivor= survivorRepository.findById(survivorID);
		
		if (survivor!=null) {
		Integer reportTimes = survivor.getReportTimes();
		
		if (reportTimes==null)
			reportTimes=0;
		
		    reportTimes++;
		    survivor.setReportTimes(reportTimes);
		    
		    // survivor reported 3 times or more
		    if( reportTimes>=3) {
		    	survivor.setFlag(true);
		    }
		
		    survivorRepository.save(survivor);
		}
		return survivor;
	}

}
