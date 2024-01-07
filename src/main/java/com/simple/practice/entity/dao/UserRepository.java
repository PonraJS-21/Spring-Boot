package com.simple.practice.entity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simple.practice.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {
	
}