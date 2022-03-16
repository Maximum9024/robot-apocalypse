package com.robot.apocalypse.model;

import java.util.List;

import lombok.Data;

@Data
public class Survivor {

	private String name;
	private String age;
	private String gender;
	private String ID;
	private Location lastLocation;
	private  List<String> inventory;
}
