package com.robot.apocalypse.util;

import java.util.Comparator;
import java.util.List;

import com.robot.apocalypse.model.Robot;

public class SortUtil {
	
	public static List<Robot> sortRobotList(List<Robot> robotsList){
		
		robotsList.sort( new Comparator<Robot>() {
			@Override
			public int compare(Robot o1, Robot o2) {
			return o1.getCategory().compareTo(o2.getCategory());
			}
		});
		return robotsList;
	}
}
