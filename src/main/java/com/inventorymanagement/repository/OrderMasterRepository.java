package com.inventorymanagement.repository;

import com.inventorymanagement.model.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterRepository extends JpaRepository<OrderMaster, Integer> {
}
