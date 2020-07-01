package com.inventorymanagement.repository;

import com.inventorymanagement.model.ProductVariantMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductVariantRepository extends JpaRepository<ProductVariantMapping, Integer> {

}
