package com.simple.practice.controllers.pojo;

public class ResponsePojo {
	private int statusCode;
	private String message;
	private String description;

	public ResponsePojo(int statusCode, String message, String description) {
		this.statusCode = statusCode;
		this.message = message;
		this.description = description;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public String getMessage() {
		return message;
	}

	public String getDescription() {
		return description;
	}
}
