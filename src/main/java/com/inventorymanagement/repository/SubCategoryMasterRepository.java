package com.inventorymanagement.repository;

import com.inventorymanagement.model.ProductMaster;
import com.inventorymanagement.model.SubCategoryMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface SubCategoryMasterRepository extends JpaRepository<SubCategoryMaster, Integer> {
    SubCategoryMaster findByName(String name);

    @Query(value = "SELECT * FROM sub_category_master WHERE cat_id = ?1 AND sub_cat_id = 0 AND active = 1 AND blocked = 0 AND deleted = 0", nativeQuery = true)
    ArrayList<SubCategoryMaster> findByCatId(int catId);

    // It will list sub category of sub category id and category id
    @Query(value = "SELECT * FROM sub_category_master WHERE cat_id = ?1 AND sub_cat_id = ?2 AND active = 1 AND blocked = 0 AND deleted = 0", nativeQuery = true)
    ArrayList<SubCategoryMaster> findSubCatOfSubCat(int catId, int subCatId);
}
