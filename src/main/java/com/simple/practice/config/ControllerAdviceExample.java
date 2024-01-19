package com.simple.practice.config;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.simple.practice.pojo.ResponsePojo;

@ControllerAdvice
public class ControllerAdviceExample {
	@ExceptionHandler
	public ResponseEntity<ResponsePojo> handler(IOException ex) {
		// If you call an endpoint http://localhost:8080/test instead of
		// http://localhost:8080/test/{YOUR_PATH} it'll throw IOException
		ResponsePojo msg = new ResponsePojo(400, HttpStatus.BAD_REQUEST.toString(), ex.getMessage());
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
	}
}
