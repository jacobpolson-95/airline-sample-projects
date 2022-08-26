package com.springboot.flightdetails.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.springboot.flightdetails.repository.model.Flight;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class FlightRepository_Test {

	@Autowired
	FlightRepository flightRepository;

	Flight flight = new Flight();

	@BeforeEach
	void setUp() {
		flight.setDestination("DEL");
		flight.setFlightNumber("1");
		flight.setDuration(1);
		flight.setOrigin("COK");
	}

	@Test
	public void save() {
		Flight flightSaved = flightRepository.save(flight);
		assertThat(flightSaved).isNotNull();
		assertThat(flightSaved.getSeqId()).isGreaterThan(0);

	}

	@Test
	public void findAllDetails() {
		flightRepository.save(flight);
		List<Flight> flightSaved = flightRepository.findAll();
		assertThat(flightSaved).isNotNull();
		assertThat(flightSaved.size()).isGreaterThan(0);

	}

	@Test
	public void findByFlightNumber() {
		flightRepository.save(flight);
		Optional<Flight> flightSaved = flightRepository.findByFlightNumber(flight.getFlightNumber());
		assertThat(flightSaved).isNotNull();

	}

	@Test
	public void findByOriginAndDestination() {
		flightRepository.save(flight);
		Optional<List<Flight>> flightSaved = flightRepository.findByOriginAndDestination(flight.getOrigin(),
				flight.getDestination());
		assertThat(flightSaved).isNotNull();

	}

	@Test
	public void deleteDetails() {
		flightRepository.save(flight);
		flightRepository.delete(flight);
		Optional<Flight> details = flightRepository.findByFlightNumber(flight.getFlightNumber());
		assertThat(details).isEmpty();
	}

}
