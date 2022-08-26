package com.springboot.flightdetails.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ErrorResponseController {

	@ExceptionHandler
	public ErrorResponse handleSecurityException(CommonException se) {
		ErrorResponse response = new ErrorResponse(se.getStatus(),se.getMessage());
        return response;
    }
}
