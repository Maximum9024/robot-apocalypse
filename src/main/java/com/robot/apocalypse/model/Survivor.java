package com.robot.apocalypse.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Data
public class Survivor {

	@javax.persistence.Id
	private Long id;
	private String name;
	private String age;
	private String gender;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Location lastLocation;
	
	@Column(name="inventory")
	@ElementCollection(targetClass=String.class)
	private  List<String> inventory;
	
	@Value(value = "false")
	private boolean flag;
	
	//number of times reported as infected
     @Value(value="0")
	 private Integer reportTimes;
}
