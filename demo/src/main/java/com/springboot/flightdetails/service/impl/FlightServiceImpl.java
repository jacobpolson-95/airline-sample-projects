package com.springboot.flightdetails.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.springboot.flightdetails.exception.CommonException;
import com.springboot.flightdetails.repository.FlightRepository;
import com.springboot.flightdetails.repository.model.Flight;
import com.springboot.flightdetails.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightRepository flightRepository;

	@Override
	public Flight CreateFlightDetails(com.springboot.flightdetails.model.Flight Flight) {
		Flight flight = new Flight();
		flight.setFlightNumber(Flight.getFlightNumber());
		flight.setDuration(Flight.getDuration());
		flight.setOrigin(Flight.getOrigin().getCode());
		flight.setDestination(Flight.getDestination().getCode());
		flightRepository.save(flight);
		return flight;
	}

	@Override
	public Flight UpdateFlightDetails(String flightNumber, com.springboot.flightdetails.model.Flight flight) {

		Flight flightDb = flightRepository.findByFlightNumber(flightNumber)
				.orElseThrow(() -> new CommonException(HttpStatus.NOT_FOUND,
						"Flight Details not found for flight number " + flightNumber));
		if (flight.getDuration() != null)
			flightDb.setDuration(flight.getDuration());
		if (flight.getOrigin().getCode() != null)
			flightDb.setOrigin(flight.getOrigin().getCode());
		if (flight.getDestination().getCode() != null)
			flightDb.setDestination(flight.getDestination().getCode());
		flightRepository.save(flightDb);
		return flightDb;
	}

	@Override
	public void DeleteFlightDetails(String flightNumber) {

		Flight flightDb = flightRepository.findByFlightNumber(flightNumber)
				.orElseThrow(() -> new CommonException(HttpStatus.NOT_FOUND,
						"Flight Details not found for flight number " + flightNumber));
		flightRepository.delete(flightDb);
	}

	@Override
	public List<Flight> GetAllFlightDetails() {

		List<Flight> flights = flightRepository.findAll();
		flights.stream().sorted((o1, o2) -> o1.getDuration() - o2.getDuration());
		return flights;
	}

	@Override
	public Flight GetFlightDetails(String flightNumber) {

		Flight flightDb = flightRepository.findByFlightNumber(flightNumber)
				.orElseThrow(() -> new CommonException(HttpStatus.NOT_FOUND,
						"Flight Details not found for flight number " + flightNumber));
		return flightDb;
	}

	@Override
	public List<Flight> GetFlightDetailsSpecific(String origin, String destination) {

		List<Flight> flightDb = flightRepository.findByOriginAndDestination(origin, destination)
				.orElseThrow(() -> new CommonException(HttpStatus.NOT_FOUND, "Flight Details not found"));
		flightDb.stream().sorted((o1, o2) -> o1.getDuration() - o2.getDuration());
		return flightDb;
	}
}