package com.springboot.flightdetails.service;

import java.util.List;
import com.springboot.flightdetails.model.Flight;

public interface FlightService {

	com.springboot.flightdetails.repository.model.Flight CreateFlightDetails(Flight Flight);

	com.springboot.flightdetails.repository.model.Flight UpdateFlightDetails(String flightNumber, Flight flight);

	void DeleteFlightDetails(String flightNumber);

	List<com.springboot.flightdetails.repository.model.Flight> GetAllFlightDetails();

	com.springboot.flightdetails.repository.model.Flight GetFlightDetails(String flightNumber);

	List<com.springboot.flightdetails.repository.model.Flight> GetFlightDetailsSpecific(String origin,
			String destination);

}
