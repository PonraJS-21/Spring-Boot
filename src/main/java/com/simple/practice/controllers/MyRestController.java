package com.simple.practice.controllers;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.simple.practice.dao.UserRepository;
import com.simple.practice.entity.UserEntity;
import com.simple.practice.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MyRestController {

	private final UserRepository userRepo;
	
	private final UserService userService;
	
	// http://localhost:8080/test/YOUR_PATH
	@GetMapping(value = { "/test", "/test/{path}" })
	private String test(@PathVariable(required = false) String path) throws IOException {
		if (Objects.isNull(path)) {
			throw new IOException("An Exception Occured");
		}
		userService.firstLevelCache();
		return new StringBuilder().append("You've sent: ").append(path).toString();
	}
	
	
	@GetMapping(value = { "/getUser", "/getUser/{id}" })
	private UserEntity getUserById(@PathVariable(required = false) String id) throws IOException {
		if (Objects.isNull(id)) {
			throw new IOException("An Exception Occured");
		}
		Optional<UserEntity> user= userRepo.findById(id);
		if (user.isPresent()) {
			return user.get();
		}
		return UserEntity.builder().userId(id).build();
	}
}
