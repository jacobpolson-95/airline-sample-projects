package com.springboot.flightdetails.service;

import java.util.List;

import com.springboot.flightdetails.model.Airport;
import com.springboot.flightdetails.model.Flight;

public interface FlightService {

	public com.springboot.flightdetails.repository.model.Flight CreateFlightDetails(Flight Flight );

	public com.springboot.flightdetails.repository.model.Flight UpdateFlightDetails(String flightNumber, Flight flight);

	public void DeleteFlightDetails(String flightNumber);

	public List<com.springboot.flightdetails.repository.model.Flight> GetAllFlightDetails();

	public com.springboot.flightdetails.repository.model.Flight GetFlightDetails(String flightNumber);

	public List<com.springboot.flightdetails.repository.model.Flight> GetFlightDetailsSpecific(String origin,
			String destination);

}
