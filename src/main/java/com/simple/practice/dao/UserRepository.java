package com.simple.practice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simple.practice.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {

	public List<UserEntity> findByUserName(String name);
}