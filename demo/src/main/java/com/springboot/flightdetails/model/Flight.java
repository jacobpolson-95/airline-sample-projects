package com.springboot.flightdetails.model;

import lombok.Data;

@Data
public class Flight {

	private String flightNumber;
	private Airport origin;
	private Airport destination;
	private Integer duration;
}
