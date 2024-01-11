package com.simple.practice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.practice.dao.UserRepository;
import com.simple.practice.entity.UserEntity;

import jakarta.transaction.Transactional;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	/*
	 * The Transactional annotation makes the method to work with single session,
	 * first level cache rely on session, when same db operation happens with same
	 * session, the second data will be fetched from session cache
	 */
	@Transactional
	public void firstLevelCache() {
		Optional<UserEntity> user = userRepository.findById("1");
		System.out.println("First Run : " + user.get() + " Now the hibernate query generated in console");
		user = userRepository.findById("1");
		System.out.println("Second Run : " + user.get() + " Now the hibernate query will not generated in console");
	}
}
