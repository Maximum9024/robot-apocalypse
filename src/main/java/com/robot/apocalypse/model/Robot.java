package com.robot.apocalypse.model;

import javax.persistence.Entity;

import lombok.Data;

@Data
public class Robot {
	private String model;
	private String serialNumber;
	private String manufacturedDate;
	private String category;

}
