package com.simple.practice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.practice.dao.UserRepository;
import com.simple.practice.entity.UserEntity;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	UserRepository userRepository;

	/*
	 * The Transactional annotation makes the method to work with single session,
	 * first level cache rely on session, when same db operation happens with same
	 * session, the second data will be fetched from session cache <br/>
	 * 
	 * Hibernate: select u1_0.user_id,u1_0.username,u1_0.password from user_cred
	 * u1_0 where u1_0.user_id=? <br/> The above query logs only one even thought
	 * the findById called twice.
	 */
	@Transactional
	public void firstLevelCache() {
		log.info("firstLevelCache method starts");
		Optional<UserEntity> user = userRepository.findById("1");
		log.info("First Run Now the hibernate query generated in console {}", user.get());
		user = userRepository.findById("1");
		log.info("Second Run Now the hibernate query will not generated in console {}", user.get());
		log.info("firstLevelCache method starts");
	}

	/**
	 * noCacheInMethod doesn't cache the data because it's using custom derived
	 * query findByUserName,
	 * 
	 * Hibernate: select u1_0.user_id,u1_0.username,u1_0.password from user_cred
	 * u1_0 where u1_0.username=? <br/>
	 * 
	 * The above query logs twice because of the derived method, the reason why it
	 * happend is in below link
	 * https://stackoverflow.com/questions/64190242/in-spring-data-jpa-a-derived-find-method-doesnt-use-first-level-cache-while-ca
	 * 
	 */
	@Transactional
	public void noCacheInMethod() {
		log.info("noCacheInMethod method starts");
		List<UserEntity> user = userRepository.findByUserName("ponraj");
		log.info("First Run Now the hibernate query generated in console {}", user);
		user = userRepository.findByUserName("ponraj");
		log.info("First Run Now the hibernate query generated in console {}", user);
		log.info("noCacheInMethod method ends");
	}
}
