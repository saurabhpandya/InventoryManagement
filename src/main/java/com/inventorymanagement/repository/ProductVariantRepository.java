package com.inventorymanagement.repository;

import com.inventorymanagement.model.ProductMaster;
import com.inventorymanagement.model.ProductVariantMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface ProductVariantRepository extends JpaRepository<ProductVariantMapping, Integer> {

    @Query(value = "SELECT * FROM product_variant_mapping WHERE p_id = ?1 AND active = 1 AND blocked = 0 AND deleted = 0", nativeQuery = true)
    ArrayList<ProductVariantMapping> findByPId(int productId);

}
