package com.springboot.flightdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.flightdetails.model.Flight;
import com.springboot.flightdetails.service.FlightService;

@RestController
@RequestMapping("/FlightManagement")
public class FlightController {

	@Autowired
	FlightService flightService;

	@PostMapping("/create")
	public ResponseEntity<com.springboot.flightdetails.repository.model.Flight> CreateFlightDetails(
			@RequestBody Flight Flight) {

		return new ResponseEntity<com.springboot.flightdetails.repository.model.Flight>(
				flightService.CreateFlightDetails(Flight), HttpStatus.CREATED);

	}

	@PutMapping("/updatebyflightnumber/{flightNumber}")
	public ResponseEntity<com.springboot.flightdetails.repository.model.Flight> UpdateFlightDetails(
			@PathVariable("flightNumber") String flightNumber, @RequestBody Flight Flight) {

		return new ResponseEntity<com.springboot.flightdetails.repository.model.Flight>(
				flightService.UpdateFlightDetails(flightNumber, Flight), HttpStatus.OK);

	}

	@DeleteMapping("/deletebyflightnumber/{flightNumber}")
	public ResponseEntity<String> Delete(@PathVariable("flightNumber") String flightNumber) {
		flightService.DeleteFlightDetails(flightNumber);
		return new ResponseEntity<String>("details deleted sucessfully for :" + flightNumber, HttpStatus.OK);

	}

	@GetMapping("/fetchAllDetails")
	public ResponseEntity<List<com.springboot.flightdetails.repository.model.Flight>> GetAllFlightDetails() {

		return new ResponseEntity<List<com.springboot.flightdetails.repository.model.Flight>>(
				flightService.GetAllFlightDetails(), HttpStatus.OK);

	}

	@GetMapping("/fetchbyflightnumber/{flightNumber}")
	public ResponseEntity<com.springboot.flightdetails.repository.model.Flight> GetFlightDetails(
			@PathVariable("flightNumber") String flightNumber) {

		return new ResponseEntity<com.springboot.flightdetails.repository.model.Flight>(
				flightService.GetFlightDetails(flightNumber), HttpStatus.OK);

	}

	@GetMapping("/fetchByOrg-Desc/{origin}/{destination}")
	public ResponseEntity<List<com.springboot.flightdetails.repository.model.Flight>> GetFlightDetailsSpecific(
			@PathVariable("origin") String origin, @PathVariable("destination") String destination) {

		return new ResponseEntity<List<com.springboot.flightdetails.repository.model.Flight>>(
				flightService.GetFlightDetailsSpecific(origin, destination), HttpStatus.OK);

	}

}
