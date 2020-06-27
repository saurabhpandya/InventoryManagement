package com.inventorymanagement.repository;

import com.inventorymanagement.model.UserTypeMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTypeMasterRepository extends JpaRepository<UserTypeMaster, Integer> {
    UserTypeMaster findByType(String type);
}
