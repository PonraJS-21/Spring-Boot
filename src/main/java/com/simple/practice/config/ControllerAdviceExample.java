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
		ResponsePojo msg = new ResponsePojo(401, HttpStatus.BAD_REQUEST.toString(), ex.getMessage());
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
	}
}
