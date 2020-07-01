package com.inventorymanagement.repository;

import com.inventorymanagement.model.CategoryMaster;
import com.inventorymanagement.model.SubCategoryMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryMasterRepository extends JpaRepository<SubCategoryMaster, Integer> {
    SubCategoryMaster findByName(String name);
}
