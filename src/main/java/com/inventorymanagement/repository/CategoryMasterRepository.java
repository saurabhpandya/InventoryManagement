package com.inventorymanagement.repository;

import com.inventorymanagement.model.CategoryMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryMasterRepository extends JpaRepository<CategoryMaster, Integer> {

    CategoryMaster findByName(String name);
}
