package com.springboot.flightdetails.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.flightdetails.repository.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
	Optional<Flight> findByFlightNumber(String flightNumber);
	Optional<List<Flight>> findByOriginAndDestination(String origin,String destination);
}
