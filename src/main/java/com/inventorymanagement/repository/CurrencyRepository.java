package com.inventorymanagement.repository;

import com.inventorymanagement.model.CurrencyMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<CurrencyMaster, Integer> {
}
