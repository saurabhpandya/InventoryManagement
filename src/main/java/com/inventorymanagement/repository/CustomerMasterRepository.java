package com.inventorymanagement.repository;

import com.inventorymanagement.model.CustomerMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerMasterRepository extends JpaRepository<CustomerMaster, Integer> {
}
