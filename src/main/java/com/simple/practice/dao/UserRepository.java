package com.simple.practice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simple.practice.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {
	
}