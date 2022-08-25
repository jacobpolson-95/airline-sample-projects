package com.springboot.flightdetails.model;

import javax.persistence.Entity;

import org.springframework.validation.annotation.Validated;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class Airport {

	private String code;
}
