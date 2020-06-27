package com.inventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventorymanagement.model.UsersMaster;

public interface UserRepository extends JpaRepository<UsersMaster, Integer> {
	UsersMaster findByEmail(String email);
}
