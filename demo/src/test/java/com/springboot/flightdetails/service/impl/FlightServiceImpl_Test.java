package com.springboot.flightdetails.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.springboot.flightdetails.exception.CommonException;
import com.springboot.flightdetails.model.Airport;
import com.springboot.flightdetails.model.Flight;
import com.springboot.flightdetails.repository.FlightRepository;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightServiceImpl_Test {

	@InjectMocks
	FlightServiceImpl flightServiceImpl;
	
	@Mock
	FlightRepository flightRepository;
	
    Flight flight=new Flight();
    Airport airport=new Airport();
	@BeforeEach
    void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
		airport.setCode("KOC");
		flight.setFlightNumber("1");
		flight.setDuration(1);
		flight.setDestination(airport);
		airport.setCode("DL");
		flight.setOrigin(airport);
    }
	
	
	@Test
	void createFlightDetails_Success() {
		
		com.springboot.flightdetails.repository.model.Flight flightDb= flightServiceImpl.CreateFlightDetails(flight);
		assertNotNull(flightDb);
	}
	
	@Test
	void updateFlightDetails_Exception() {
		
		when(flightRepository.findByFlightNumber(any())).thenReturn(Optional.empty());
		CommonException thrown = assertThrows(CommonException.class, () -> {
			flightServiceImpl.UpdateFlightDetails(any(), flight);
		}); 
		assertTrue(thrown.getMessage().contains("Flight Details not found for flight number"));
		
		
	}
	@Test
	void updateFlightDetails_Success() {
		when(flightRepository.findByFlightNumber(any())).thenReturn(Optional.of(new com.springboot.flightdetails.repository.model.Flight()));
		com.springboot.flightdetails.repository.model.Flight flightDb=flightServiceImpl.UpdateFlightDetails(any(), flight);
		assertNotNull(flightDb);
	}
	
	@Test
	void deleteFlightDetails_Exception() {
		
		when(flightRepository.findByFlightNumber(any())).thenReturn(Optional.empty());
		CommonException thrown = assertThrows(CommonException.class, () -> {
			flightServiceImpl.DeleteFlightDetails(any());
		}); 
		assertTrue(thrown.getMessage().contains("Flight Details not found for flight number"));
		
		
	}
	
	@Test
	void deleteFlightDetails_Success() {
		when(flightRepository.findByFlightNumber(any())).thenReturn(Optional.of(new com.springboot.flightdetails.repository.model.Flight()));
		flightServiceImpl.DeleteFlightDetails(any());
	}
	
	@Test
	void GetAllFlightDetails_Success() {
		List<com.springboot.flightdetails.repository.model.Flight>flightDbList=new ArrayList<>();
		com.springboot.flightdetails.repository.model.Flight flightDb=new com.springboot.flightdetails.repository.model.Flight();
		flightDbList.add(flightDb);
		when(flightRepository.findAll()).thenReturn(flightDbList);
		flightServiceImpl.GetAllFlightDetails();
		assertNotNull(flightDbList);
	}
	
	@Test
	void GetFlightDetails_Success() {
		com.springboot.flightdetails.repository.model.Flight flight= new com.springboot.flightdetails.repository.model.Flight();
		when(flightRepository.findByFlightNumber(any())).thenReturn(Optional.of(flight));
		flight=flightServiceImpl.GetFlightDetails(any());
		assertNotNull(flight);
	}
	
	@Test
	void GetFlightDetails_Exception() {
		
		when(flightRepository.findByFlightNumber(any())).thenReturn(Optional.empty());
		CommonException thrown = assertThrows(CommonException.class, () -> {
			flightServiceImpl.GetFlightDetails(any());
		}); 
		assertTrue(thrown.getMessage().contains("Flight Details not found for flight number"));
		
		
	}
	
	@Test
	void GetFlightDetailsSpecific_Success() {
		List<com.springboot.flightdetails.repository.model.Flight> flight= new ArrayList<>();
		flight.add(new com.springboot.flightdetails.repository.model.Flight());
		when(flightRepository.findByOriginAndDestination(any(),any())).thenReturn(Optional.of(flight));
		flight=flightServiceImpl.GetFlightDetailsSpecific(any(),any());
		assertNotNull(flight);
	}
	
	@Test
	void GetFlightDetailsSpecific_Exception() {
		
		when(flightRepository.findByOriginAndDestination(any(),any())).thenReturn(Optional.empty());
		CommonException thrown = assertThrows(CommonException.class, () -> {
			flightServiceImpl.GetFlightDetailsSpecific(any(),any());
		}); 
		assertTrue(thrown.getMessage().contains("Flight Details not found"));
		
		
	}
}
