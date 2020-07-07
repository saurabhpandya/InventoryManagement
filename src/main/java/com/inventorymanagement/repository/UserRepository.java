package com.inventorymanagement.repository;

import com.inventorymanagement.model.UsersMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UsersMaster, Integer> {
    UsersMaster findByEmail(String email);
}
