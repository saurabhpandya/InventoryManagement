package com.inventorymanagement.repository;

import com.inventorymanagement.model.LocationMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationMappingRepository extends JpaRepository<LocationMapping, Integer> {
}
