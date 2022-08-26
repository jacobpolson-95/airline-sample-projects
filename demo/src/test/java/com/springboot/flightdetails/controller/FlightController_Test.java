package com.springboot.flightdetails.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.springboot.flightdetails.model.Airport;
import com.springboot.flightdetails.model.Flight;
import com.springboot.flightdetails.service.FlightService;

public class FlightController_Test {

	@InjectMocks
	FlightController flightController;

	@Mock
	FlightService flightService;

	Flight flight = new Flight();
	Airport airport = new Airport();

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		airport.setCode("KOC");
		flight.setFlightNumber("1");
		flight.setDuration(1);
		flight.setDestination(airport);
		airport.setCode("DL");
		flight.setOrigin(airport);
	}

	@Test
	void CreateFlightDetails() {
		ResponseEntity<com.springboot.flightdetails.repository.model.Flight> responseEntity = new ResponseEntity<com.springboot.flightdetails.repository.model.Flight>(
				HttpStatus.CREATED);
		when(flightService.UpdateFlightDetails(anyString(), any(Flight.class)))
				.thenReturn(new com.springboot.flightdetails.repository.model.Flight());
		responseEntity = flightController.CreateFlightDetails(flight);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
	}

	@Test
	void UpdateFlightDetails() {
		ResponseEntity<com.springboot.flightdetails.repository.model.Flight> responseEntity = new ResponseEntity<com.springboot.flightdetails.repository.model.Flight>(
				HttpStatus.OK);
		when(flightService.UpdateFlightDetails(anyString(), any(Flight.class)))
				.thenReturn(new com.springboot.flightdetails.repository.model.Flight());
		responseEntity = flightController.UpdateFlightDetails("1", flight);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}

	@Test
	void DeleteFlightDetails() {
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(HttpStatus.OK);
		flightService.DeleteFlightDetails(any());
		responseEntity = flightController.Delete("1");
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}

	@Test
	void FetchAllDetails() {
		ResponseEntity<List<com.springboot.flightdetails.repository.model.Flight>> responseEntity = new ResponseEntity<List<com.springboot.flightdetails.repository.model.Flight>>(
				HttpStatus.OK);
		List<com.springboot.flightdetails.repository.model.Flight> flights = new ArrayList<>();
		flights.add(new com.springboot.flightdetails.repository.model.Flight());
		when(flightService.GetAllFlightDetails()).thenReturn(flights);
		responseEntity = flightController.GetAllFlightDetails();
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);

	}

	@Test
	void GetFlightDetails() {
		ResponseEntity<com.springboot.flightdetails.repository.model.Flight> responseEntity = new ResponseEntity<com.springboot.flightdetails.repository.model.Flight>(
				HttpStatus.OK);
		when(flightService.GetFlightDetails(any()))
				.thenReturn(new com.springboot.flightdetails.repository.model.Flight());
		responseEntity = flightController.GetFlightDetails("1");
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);

	}

	@Test
	void GetFlightDetailsSpecific() {
		ResponseEntity<List<com.springboot.flightdetails.repository.model.Flight>> responseEntity = new ResponseEntity<List<com.springboot.flightdetails.repository.model.Flight>>(
				HttpStatus.OK);
		List<com.springboot.flightdetails.repository.model.Flight> flights = new ArrayList<>();
		flights.add(new com.springboot.flightdetails.repository.model.Flight());
		when(flightService.GetFlightDetailsSpecific(any(), any())).thenReturn(flights);
		responseEntity = flightController.GetFlightDetailsSpecific("cok", "DEL");
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);

	}
}
