package com.springboot.flightdetails.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorResponse {

	private HttpStatus status;
	private String message;
	public ErrorResponse(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	
}
