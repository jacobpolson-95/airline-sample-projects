package com.springboot.flightdetails.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.validation.annotation.Validated;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Table(name="flight_details")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="seq_id")
	private Integer seqId;
	@Column(name="flight_number",unique = true)
	private String flightNumber;
	@Column(name="origin")
	private String origin;
	@Column(name="destination")
	private String destination;
	@Column(name="duration")
	private Integer duration;
}
