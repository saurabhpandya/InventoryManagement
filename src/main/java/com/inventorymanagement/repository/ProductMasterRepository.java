package com.inventorymanagement.repository;

import com.inventorymanagement.model.ProductMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface ProductMasterRepository extends JpaRepository<ProductMaster, Integer> {
    ProductMaster findByName(String name);

    @Query(value = "SELECT * FROM product_master WHERE sub_cat_id = ?1 AND active = 1 AND blocked = 0 AND deleted = 0", nativeQuery = true)
    ArrayList<ProductMaster> findProductsBySubCat(int subCatId);

//    @Query(value = "SELECT * FROM product_master as p LEFT JOIN product_varient_mapping as pvm on p.id = pvm.product_id where p.id = ?1 AND p.active = 1 AND p.blocked = 0 AND p.deleted = 0", nativeQuery = true)
//    ProductMaster getProductDetailByProductId(int productId);

}
