package com.robot.apocalypse.model;

import java.util.List;

import lombok.Data;

@Data
public class SurvivorList {
	public SurvivorList() {}
	private List<Survivor> nonInfected;
	private List<Survivor> infected;
}
