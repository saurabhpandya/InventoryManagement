package com.inventorymanagement.controller

import com.inventorymanagement.constants.ApiConstants.Companion.API_V1_MASTER
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_CATEGORY_DELETE
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_CATEGORY_GET
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_CATEGORY_SAVE
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_CATEGORY_UPDATE
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_CURRENCY_DELETE
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_CURRENCY_GET
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_CURRENCY_SAVE
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_CURRENCY_UPDATE
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_CUSTOMER
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_CUSTOMER_DELETE
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_CUSTOMER_GET
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_CUSTOMER_SAVE
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_CUSTOMER_UPDATE
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_LOCATION
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_LOCATION_DELETE
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_LOCATION_GET
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_LOCATION_SAVE
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_LOCATION_UPDATE
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_MASTER_CATEGORY
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_MASTER_CURRENCY
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_MASTER_PRODUCT
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_MASTER_PRODUCT_VARIANT
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_MASTER_SUB_CATEGORY
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_MASTER_USERTYPE
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_ORDER
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_ORDER_DELETE
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_ORDER_GET
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_ORDER_SAVE
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_ORDER_UPDATE
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_PRODUCT_DELETE
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_PRODUCT_GET
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_PRODUCT_SAVE
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_PRODUCT_UPDATE
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_PRODUCT_VARIANT_DELETE
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_PRODUCT_VARIANT_GET
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_PRODUCT_VARIANT_SAVE
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_PRODUCT_VARIANT_UPDATE
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_SUB_CATEGORY_DELETE
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_SUB_CATEGORY_GET
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_SUB_CATEGORY_SAVE
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_SUB_CATEGORY_UPDATE
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_SUPPLIER
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_SUPPLIER_DELETE
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_SUPPLIER_GET
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_SUPPLIER_SAVE
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_SUPPLIER_UPDATE
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_USERTYPE_DELETE
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_USERTYPE_GET
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_USERTYPE_SAVE
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_USERTYPE_UPDATE
import com.inventorymanagement.constants.Constants.Companion.msg_category_deleted
import com.inventorymanagement.constants.Constants.Companion.msg_category_exist
import com.inventorymanagement.constants.Constants.Companion.msg_category_saved
import com.inventorymanagement.constants.Constants.Companion.msg_category_updated
import com.inventorymanagement.constants.Constants.Companion.msg_currency_deleted
import com.inventorymanagement.constants.Constants.Companion.msg_currency_exist
import com.inventorymanagement.constants.Constants.Companion.msg_currency_saved
import com.inventorymanagement.constants.Constants.Companion.msg_currency_updated
import com.inventorymanagement.constants.Constants.Companion.msg_customer_deleted
import com.inventorymanagement.constants.Constants.Companion.msg_customer_exist
import com.inventorymanagement.constants.Constants.Companion.msg_customer_saved
import com.inventorymanagement.constants.Constants.Companion.msg_customer_updated
import com.inventorymanagement.constants.Constants.Companion.msg_location_deleted
import com.inventorymanagement.constants.Constants.Companion.msg_location_exist
import com.inventorymanagement.constants.Constants.Companion.msg_location_saved
import com.inventorymanagement.constants.Constants.Companion.msg_location_updated
import com.inventorymanagement.constants.Constants.Companion.msg_no_category_found
import com.inventorymanagement.constants.Constants.Companion.msg_no_change_updated
import com.inventorymanagement.constants.Constants.Companion.msg_no_currency_found
import com.inventorymanagement.constants.Constants.Companion.msg_no_customer_found
import com.inventorymanagement.constants.Constants.Companion.msg_no_location_found
import com.inventorymanagement.constants.Constants.Companion.msg_no_order_found
import com.inventorymanagement.constants.Constants.Companion.msg_no_product_found
import com.inventorymanagement.constants.Constants.Companion.msg_no_product_variant_found
import com.inventorymanagement.constants.Constants.Companion.msg_no_sub_category_found
import com.inventorymanagement.constants.Constants.Companion.msg_no_supplier_found
import com.inventorymanagement.constants.Constants.Companion.msg_no_user_type_found
import com.inventorymanagement.constants.Constants.Companion.msg_no_users_found
import com.inventorymanagement.constants.Constants.Companion.msg_order_deleted
import com.inventorymanagement.constants.Constants.Companion.msg_order_exist
import com.inventorymanagement.constants.Constants.Companion.msg_order_saved
import com.inventorymanagement.constants.Constants.Companion.msg_order_updated
import com.inventorymanagement.constants.Constants.Companion.msg_product_deleted
import com.inventorymanagement.constants.Constants.Companion.msg_product_exist
import com.inventorymanagement.constants.Constants.Companion.msg_product_saved
import com.inventorymanagement.constants.Constants.Companion.msg_product_updated
import com.inventorymanagement.constants.Constants.Companion.msg_product_variant_deleted
import com.inventorymanagement.constants.Constants.Companion.msg_product_variant_exist
import com.inventorymanagement.constants.Constants.Companion.msg_product_variant_saved
import com.inventorymanagement.constants.Constants.Companion.msg_product_variant_updated
import com.inventorymanagement.constants.Constants.Companion.msg_sub_category_deleted
import com.inventorymanagement.constants.Constants.Companion.msg_sub_category_exist
import com.inventorymanagement.constants.Constants.Companion.msg_sub_category_saved
import com.inventorymanagement.constants.Constants.Companion.msg_sub_category_updated
import com.inventorymanagement.constants.Constants.Companion.msg_supplier_deleted
import com.inventorymanagement.constants.Constants.Companion.msg_supplier_exist
import com.inventorymanagement.constants.Constants.Companion.msg_supplier_saved
import com.inventorymanagement.constants.Constants.Companion.msg_supplier_updated
import com.inventorymanagement.constants.Constants.Companion.msg_user_type_deleted
import com.inventorymanagement.constants.Constants.Companion.msg_user_type_exist
import com.inventorymanagement.constants.Constants.Companion.msg_user_type_saved
import com.inventorymanagement.constants.Constants.Companion.msg_user_type_updated
import com.inventorymanagement.extension.*
import com.inventorymanagement.model.*
import com.inventorymanagement.model.base.BaseResponse
import com.inventorymanagement.model.base.CommonResponse
import com.inventorymanagement.model.base.ErrorResponse
import com.inventorymanagement.repository.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(API_V1_MASTER)
class MasterController {

    @Autowired
    private val userTypeRepo: UserTypeMasterRepository? = null

    @Autowired
    private val categoryMasterRepo: CategoryMasterRepository? = null

    @Autowired
    private val subCategoryMasterRepo: SubCategoryMasterRepository? = null

    @Autowired
    private val productMasterRepo: ProductMasterRepository? = null

    @Autowired
    private val productVariantRepo: ProductVariantRepository? = null

    @Autowired
    private val currencyRepo: CurrencyRepository? = null

    @GetMapping(ENDPOINT_MASTER_CURRENCY)
    fun getAllCurrency(): BaseResponse<MutableList<CurrencyMaster>> {
        val currencyListBaseResponse = BaseResponse<MutableList<CurrencyMaster>>()
        val currencyList = currencyRepo?.findAll()
        if (currencyList.isNullOrEmpty()) {
            currencyListBaseResponse.errorResponse = ErrorResponse().getErrorResponse(100, msg_no_currency_found)
        } else {
            currencyListBaseResponse.data = currencyList
        }
        return currencyListBaseResponse
    }

    @GetMapping(ENDPOINT_CURRENCY_GET)
    fun getCurrencyById(@PathVariable("id") id: Int): BaseResponse<CurrencyMaster> {
        val currencyBaseResponse = BaseResponse<CurrencyMaster>()
        try {
            val currency = currencyRepo?.findById(id)
            if (!currency?.isEmpty!!) {
                currencyBaseResponse.data = currency.get()
            } else {
                currencyBaseResponse.errorResponse = ErrorResponse().getErrorResponse(100, msg_no_currency_found)
            }
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            currencyBaseResponse.errorResponse = ErrorResponse().getErrorResponse(100, msg_no_currency_found)
        }
        return currencyBaseResponse
    }

    @PostMapping(ENDPOINT_CURRENCY_SAVE)
    fun saveCurrency(@RequestBody saveCurrency: CurrencyMaster): BaseResponse<CommonResponse> {
        val saveCurrencyBaseResponse = BaseResponse<CommonResponse>()
        try {
            currencyRepo?.save(saveCurrency)
            saveCurrencyBaseResponse.data = CommonResponse().getCommonResponse(msg_currency_saved)
        } catch (e: Exception) {
            e.printStackTrace()
            println(e.localizedMessage)
            val errorResponse = ErrorResponse().getErrorResponse(0, e.localizedMessage)
            saveCurrencyBaseResponse.errorResponse = errorResponse
        }
        return saveCurrencyBaseResponse
    }

    @PutMapping(ENDPOINT_CURRENCY_UPDATE)
    fun updateCurrency(@RequestBody updateCurrency: CurrencyMaster): BaseResponse<CommonResponse> {
        val updateCurrencyBaseResponse = BaseResponse<CommonResponse>()

        val currency = currencyRepo?.findById(updateCurrency.id)
        if (currency == null) {
            // type is not exist
            try {
                currencyRepo?.save(updateCurrency)
                updateCurrencyBaseResponse.data = CommonResponse().getCommonResponse(msg_currency_updated)
            } catch (e: Exception) {
                e.printStackTrace()
                println(e.localizedMessage)
                val errorResponse = ErrorResponse().getErrorResponse(0, e.localizedMessage)
                updateCurrencyBaseResponse.errorResponse = errorResponse
            }
        } else {
            // type is exist
            if (updateCurrency.id.equals(currency.get().id)) {
                updateCurrencyBaseResponse.data = CommonResponse().getCommonResponse(msg_no_change_updated)
            } else {
                val errorResponse = ErrorResponse().getErrorResponse(100, msg_currency_exist)
                updateCurrencyBaseResponse.errorResponse = errorResponse
            }
        }
        return updateCurrencyBaseResponse
    }

    @PostMapping(ENDPOINT_CURRENCY_DELETE)
    fun deleteCurrency(@RequestBody deleteCurrency: CurrencyMaster): BaseResponse<CommonResponse> {
        val deleteCommonBaseResponse = BaseResponse<CommonResponse>()
        var currencyValidatorPair = deleteCurrency.idValid()
        if (currencyValidatorPair.first) {
            val currencyOptional = currencyRepo?.findById(deleteCurrency.id)
            if (!currencyOptional?.isEmpty!!) {
                // type is not exist
                try {
                    val currency = currencyOptional.get()
                    currency.isDeleted = true
                    currencyRepo?.save(currency)
                    deleteCommonBaseResponse.data = CommonResponse().getCommonResponse(msg_currency_deleted)
                } catch (e: Exception) {
                    e.printStackTrace()
                    val errorResponse = ErrorResponse().getErrorResponse(0, e.localizedMessage)
                    deleteCommonBaseResponse.errorResponse = errorResponse
                }
            } else {
                // type is exist
                val errorResponse = ErrorResponse().getErrorResponse(100, msg_currency_exist)
                deleteCommonBaseResponse.errorResponse = errorResponse
            }
        } else {
            val errorResponse = ErrorResponse().getErrorResponse(100, currencyValidatorPair.second)
            deleteCommonBaseResponse.errorResponse = errorResponse
        }
        return deleteCommonBaseResponse
    }

    @GetMapping(ENDPOINT_MASTER_PRODUCT_VARIANT)
    fun getProductVariants(): BaseResponse<MutableList<ProductVariantMapping>> {
        val productVariantListBaseResponse = BaseResponse<MutableList<ProductVariantMapping>>()
        val productVariantList = productVariantRepo?.findAll()
        if (productVariantList.isNullOrEmpty()) {
            productVariantListBaseResponse.errorResponse = ErrorResponse().getErrorResponse(100, msg_no_product_variant_found)
        } else {
            productVariantListBaseResponse.data = productVariantList
        }
        return productVariantListBaseResponse
    }

    @GetMapping(ENDPOINT_PRODUCT_VARIANT_GET)
    fun getProductVariantById(@PathVariable("id") id: Int): BaseResponse<ProductVariantMapping> {
        val productVariantBaseResponse = BaseResponse<ProductVariantMapping>()
        try {
            val productVariant = productVariantRepo?.findById(id)
            if (!productVariant?.isEmpty!!) {
                productVariantBaseResponse.data = productVariant.get()
            } else {
                productVariantBaseResponse.errorResponse = ErrorResponse().getErrorResponse(100, msg_no_product_variant_found)
            }
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            productVariantBaseResponse.errorResponse = ErrorResponse().getErrorResponse(100, msg_no_product_variant_found)
        }
        return productVariantBaseResponse
    }

    @PostMapping(ENDPOINT_PRODUCT_VARIANT_SAVE)
    fun saveProductVariant(@RequestBody saveProductVariant: ProductVariantMapping): BaseResponse<CommonResponse> {
        val saveProductVariantBaseResponse = BaseResponse<CommonResponse>()
        try {
            productVariantRepo?.save(saveProductVariant)
            saveProductVariantBaseResponse.data = CommonResponse().getCommonResponse(msg_product_variant_saved)
        } catch (e: Exception) {
            e.printStackTrace()
            println(e.localizedMessage)
            val errorResponse = ErrorResponse().getErrorResponse(0, e.localizedMessage)
            saveProductVariantBaseResponse.errorResponse = errorResponse
        }
        return saveProductVariantBaseResponse
    }

    @PutMapping(ENDPOINT_PRODUCT_VARIANT_UPDATE)
    fun updateProductVariant(@RequestBody updateProductVariant: ProductVariantMapping): BaseResponse<CommonResponse> {
        val updateProductVariantBaseResponse = BaseResponse<CommonResponse>()

        val productMaster = productMasterRepo?.findById(updateProductVariant.id)
        if (productMaster == null) {
            // type is not exist
            try {
                productVariantRepo?.save(updateProductVariant)
                updateProductVariantBaseResponse.data = CommonResponse().getCommonResponse(msg_product_variant_updated)
            } catch (e: Exception) {
                e.printStackTrace()
                println(e.localizedMessage)
                val errorResponse = ErrorResponse().getErrorResponse(0, e.localizedMessage)
                updateProductVariantBaseResponse.errorResponse = errorResponse
            }
        } else {
            // type is exist
            if (updateProductVariant.id.equals(productMaster.get().id)) {
                updateProductVariantBaseResponse.data = CommonResponse().getCommonResponse(msg_no_change_updated)
            } else {
                val errorResponse = ErrorResponse().getErrorResponse(100, msg_product_exist)
                updateProductVariantBaseResponse.errorResponse = errorResponse
            }
        }
        return updateProductVariantBaseResponse
    }

    @PostMapping(ENDPOINT_PRODUCT_VARIANT_DELETE)
    fun deleteProductVariant(@RequestBody deleteProductVariant: ProductVariantMapping): BaseResponse<CommonResponse> {
        val deleteCommonBaseResponse = BaseResponse<CommonResponse>()
        var productVariantValidatorPair = deleteProductVariant.idValid()
        if (productVariantValidatorPair.first) {
            val productVariantOptional = productVariantRepo?.findById(deleteProductVariant.id)
            if (!productVariantOptional?.isEmpty!!) {
                // type is not exist
                try {
                    val productVariant = productVariantOptional.get()
                    productVariant.isDeleted = true
                    productVariantRepo?.save(productVariant)
                    deleteCommonBaseResponse.data = CommonResponse().getCommonResponse(msg_product_variant_deleted)
                } catch (e: Exception) {
                    e.printStackTrace()
                    val errorResponse = ErrorResponse().getErrorResponse(0, e.localizedMessage)
                    deleteCommonBaseResponse.errorResponse = errorResponse
                }
            } else {
                // type is exist
                val errorResponse = ErrorResponse().getErrorResponse(100, msg_product_variant_exist)
                deleteCommonBaseResponse.errorResponse = errorResponse
            }
        } else {
            val errorResponse = ErrorResponse().getErrorResponse(100, productVariantValidatorPair.second)
            deleteCommonBaseResponse.errorResponse = errorResponse
        }
        return deleteCommonBaseResponse
    }

    @GetMapping(ENDPOINT_MASTER_PRODUCT)
    fun getProducts(): BaseResponse<MutableList<ProductMaster>> {
        val productListBaseResponse = BaseResponse<MutableList<ProductMaster>>()
        val productList = productMasterRepo?.findAll()
        if (productList.isNullOrEmpty()) {
            productListBaseResponse.errorResponse = ErrorResponse().getErrorResponse(100, msg_no_product_found)
        } else {
            productListBaseResponse.data = productList
        }
        return productListBaseResponse
    }

    @GetMapping(ENDPOINT_PRODUCT_GET)
    fun getProductById(@PathVariable("id") id: Int): BaseResponse<ProductMaster> {
        val productBaseResponse = BaseResponse<ProductMaster>()
        try {
            val productMaster = productMasterRepo?.findById(id)
            if (!productMaster?.isEmpty!!) {
                productBaseResponse.data = productMaster.get()
            } else {
                productBaseResponse.errorResponse = ErrorResponse().getErrorResponse(100, msg_no_product_found)
            }
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            productBaseResponse.errorResponse = ErrorResponse().getErrorResponse(100, msg_no_product_found)
        }
        return productBaseResponse
    }

    @PostMapping(ENDPOINT_PRODUCT_SAVE)
    fun saveProduct(@RequestBody saveProductMaster: ProductMaster): BaseResponse<CommonResponse> {
        val saveProductBaseResponse = BaseResponse<CommonResponse>()
        var productValidatorPair = saveProductMaster.nameValid()
        if (productValidatorPair.first) {
            val productMaster = productMasterRepo?.findByName(saveProductMaster.name)
            if (productMaster == null) {
                // type is not exist
                try {
                    productMasterRepo?.save(saveProductMaster)
                    saveProductBaseResponse.data = CommonResponse().getCommonResponse(msg_product_saved)
                } catch (e: Exception) {
                    e.printStackTrace()
                    println(e.localizedMessage)
                    val errorResponse = ErrorResponse().getErrorResponse(0, e.localizedMessage)
                    saveProductBaseResponse.errorResponse = errorResponse
                }
            } else {
                // type is exist
                val errorResponse = ErrorResponse().getErrorResponse(100, msg_product_exist)
                saveProductBaseResponse.errorResponse = errorResponse
            }
        } else {
            val errorResponse = ErrorResponse().getErrorResponse(100, productValidatorPair.second)
            saveProductBaseResponse.errorResponse = errorResponse
        }
        return saveProductBaseResponse
    }

    @PutMapping(ENDPOINT_PRODUCT_UPDATE)
    fun updateProduct(@RequestBody updateProductMaster: ProductMaster): BaseResponse<CommonResponse> {
        val updateProductBaseResponse = BaseResponse<CommonResponse>()
        var productValidatorPair = updateProductMaster.nameValid()
        if (productValidatorPair.first) {
            val productMaster = productMasterRepo?.findByName(updateProductMaster.name)
            if (productMaster == null) {
                // type is not exist
                try {
                    productMasterRepo?.save(updateProductMaster)
                    updateProductBaseResponse.data = CommonResponse().getCommonResponse(msg_product_updated)
                } catch (e: Exception) {
                    e.printStackTrace()
                    println(e.localizedMessage)
                    val errorResponse = ErrorResponse().getErrorResponse(0, e.localizedMessage)
                    updateProductBaseResponse.errorResponse = errorResponse
                }
            } else {
                // type is exist
                if (updateProductMaster.id.equals(productMaster.id)) {
                    updateProductBaseResponse.data = CommonResponse().getCommonResponse(msg_no_change_updated)
                } else {
                    val errorResponse = ErrorResponse().getErrorResponse(100, msg_product_exist)
                    updateProductBaseResponse.errorResponse = errorResponse
                }
            }
        } else {
            val errorResponse = ErrorResponse().getErrorResponse(100, productValidatorPair.second)
            updateProductBaseResponse.errorResponse = errorResponse
        }
        return updateProductBaseResponse
    }

    @PostMapping(ENDPOINT_PRODUCT_DELETE)
    fun deleteProduct(@RequestBody deleteProductMaster: ProductMaster): BaseResponse<CommonResponse> {
        val deleteCommonBaseResponse = BaseResponse<CommonResponse>()
        var productValidatorPair = deleteProductMaster.idValid()
        if (productValidatorPair.first) {
            val productMasterOptional = productMasterRepo?.findById(deleteProductMaster.id)
            if (!productMasterOptional?.isEmpty!!) {
                // type is not exist
                try {
                    val productMaster = productMasterOptional.get()
                    productMaster.isDeleted = true
                    productMasterRepo?.save(productMaster)
                    deleteCommonBaseResponse.data = CommonResponse().getCommonResponse(msg_product_deleted)
                } catch (e: Exception) {
                    e.printStackTrace()
                    println("${e.localizedMessage}")
                    val errorResponse = ErrorResponse().getErrorResponse(0, e.localizedMessage)
                    deleteCommonBaseResponse.errorResponse = errorResponse
                }
            } else {
                // type is exist
                val errorResponse = ErrorResponse().getErrorResponse(100, msg_product_exist)
                deleteCommonBaseResponse.errorResponse = errorResponse
            }
        } else {
            val errorResponse = ErrorResponse().getErrorResponse(100, productValidatorPair.second)
            deleteCommonBaseResponse.errorResponse = errorResponse
        }
        return deleteCommonBaseResponse
    }

    @GetMapping(ENDPOINT_MASTER_SUB_CATEGORY)
    fun getSubCategories(): BaseResponse<MutableList<SubCategoryMaster>> {
        val subCatListBaseResponse = BaseResponse<MutableList<SubCategoryMaster>>()
        val subCatList = subCategoryMasterRepo?.findAll()
        if (subCatList.isNullOrEmpty()) {
            subCatListBaseResponse.errorResponse = ErrorResponse().getErrorResponse(100, msg_no_sub_category_found)
        } else {
            subCatListBaseResponse.data = subCatList
        }
        return subCatListBaseResponse
    }

    @GetMapping(ENDPOINT_SUB_CATEGORY_GET)
    fun getSubCategoryById(@PathVariable("id") id: Int): BaseResponse<SubCategoryMaster> {
        val subCatBaseResponse = BaseResponse<SubCategoryMaster>()
        try {
            val subCategory = subCategoryMasterRepo?.findById(id)
            if (!subCategory?.isEmpty!!) {
                subCatBaseResponse.data = subCategory.get()
            } else {
                subCatBaseResponse.errorResponse = ErrorResponse().getErrorResponse(100, msg_no_sub_category_found)

            }
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            subCatBaseResponse.errorResponse = ErrorResponse().getErrorResponse(100, msg_no_sub_category_found)
        }
        return subCatBaseResponse
    }

    @PostMapping(ENDPOINT_SUB_CATEGORY_SAVE)
    fun saveSubCategory(@RequestBody saveSubCategory: SubCategoryMaster): BaseResponse<CommonResponse> {
        val saveSubCatBaseResponse = BaseResponse<CommonResponse>()
        var subCatValidatorPair = saveSubCategory.nameValid()
        if (subCatValidatorPair.first) {
            val subCatMaster = subCategoryMasterRepo?.findByName(saveSubCategory.name)
            if (subCatMaster == null) {
                // type is not exist
                try {
                    subCategoryMasterRepo?.save(saveSubCategory)
                    println(msg_category_saved)
                    saveSubCatBaseResponse.data = CommonResponse().getCommonResponse(msg_sub_category_saved)
                } catch (e: Exception) {
                    e.printStackTrace()
                    println(e.localizedMessage)
                    val errorResponse = ErrorResponse().getErrorResponse(0, e.localizedMessage)
                    saveSubCatBaseResponse.errorResponse = errorResponse
                }
            } else {
                // type is exist
                println(msg_sub_category_exist)
                val errorResponse = ErrorResponse().getErrorResponse(100, msg_sub_category_exist)
                saveSubCatBaseResponse.errorResponse = errorResponse
            }
        } else {
            val errorResponse = ErrorResponse().getErrorResponse(100, subCatValidatorPair.second)
            saveSubCatBaseResponse.errorResponse = errorResponse
        }
        return saveSubCatBaseResponse
    }

    @PutMapping(ENDPOINT_SUB_CATEGORY_UPDATE)
    fun updateSubCategory(@RequestBody updateSubCategory: SubCategoryMaster): BaseResponse<CommonResponse> {
        val updateSubCatBaseResponse = BaseResponse<CommonResponse>()
        var subCatValidatorPair = updateSubCategory.nameValid()
        if (subCatValidatorPair.first) {
            val subCatMaster = subCategoryMasterRepo?.findByName(updateSubCategory.name)
            if (subCatMaster == null) {
                // type is not exist
                try {
                    subCategoryMasterRepo?.save(updateSubCategory)
                    updateSubCatBaseResponse.data = CommonResponse().getCommonResponse(msg_sub_category_updated)
                } catch (e: Exception) {
                    e.printStackTrace()
                    println(e.localizedMessage)
                    val errorResponse = ErrorResponse().getErrorResponse(0, e.localizedMessage)
                    updateSubCatBaseResponse.errorResponse = errorResponse
                }
            } else {
                // type is exist
                if (updateSubCategory.id.equals(subCatMaster.id)) {
                    updateSubCatBaseResponse.data = CommonResponse().getCommonResponse(msg_no_change_updated)
                } else {
                    val errorResponse = ErrorResponse().getErrorResponse(100, msg_sub_category_exist)
                    updateSubCatBaseResponse.errorResponse = errorResponse
                }

            }
        } else {
            val errorResponse = ErrorResponse().getErrorResponse(100, subCatValidatorPair.second)
            updateSubCatBaseResponse.errorResponse = errorResponse
        }
        return updateSubCatBaseResponse
    }

    @PostMapping(ENDPOINT_SUB_CATEGORY_DELETE)
    fun deleteSubCategory(@RequestBody deleteSubCategoryMaster: SubCategoryMaster): BaseResponse<CommonResponse> {
        val deleteCommonBaseResponse = BaseResponse<CommonResponse>()
        var subCatValidatorPair = deleteSubCategoryMaster.idValid()
        if (subCatValidatorPair.first) {
            val subCatMasterOptional = subCategoryMasterRepo?.findById(deleteSubCategoryMaster.id)
            if (!subCatMasterOptional?.isEmpty!!) {
                // type is not exist
                try {
                    val subCatMaster = subCatMasterOptional.get()
                    subCatMaster.isDeleted = true
                    subCategoryMasterRepo?.save(subCatMaster)
                    deleteCommonBaseResponse.data = CommonResponse().getCommonResponse(msg_sub_category_deleted)
                } catch (e: Exception) {
                    e.printStackTrace()
                    println("${e.localizedMessage}")
                    val errorResponse = ErrorResponse().getErrorResponse(0, e.localizedMessage)
                    deleteCommonBaseResponse.errorResponse = errorResponse
                }
            } else {
                // type is exist
                val errorResponse = ErrorResponse().getErrorResponse(100, msg_sub_category_exist)
                deleteCommonBaseResponse.errorResponse = errorResponse
            }
        } else {
            val errorResponse = ErrorResponse().getErrorResponse(100, subCatValidatorPair.second)
            deleteCommonBaseResponse.errorResponse = errorResponse
        }
        return deleteCommonBaseResponse
    }

    @GetMapping(ENDPOINT_MASTER_CATEGORY)
    fun getCategories(): BaseResponse<MutableList<CategoryMaster>> {
        val categoryListBaseResponse = BaseResponse<MutableList<CategoryMaster>>()
        val categoryList = categoryMasterRepo?.findAll()
        if (categoryList.isNullOrEmpty()) {
            categoryListBaseResponse.errorResponse = ErrorResponse().getErrorResponse(100, msg_no_category_found)
        } else {
            categoryListBaseResponse.data = categoryList
        }
        return categoryListBaseResponse
    }

    @GetMapping(ENDPOINT_CATEGORY_GET)
    fun getCategoryById(@PathVariable("id") id: Int): BaseResponse<CategoryMaster> {
        val categoryBaseResponse = BaseResponse<CategoryMaster>()
        try {
            val category = categoryMasterRepo?.findById(id)
            if (!category?.isEmpty!!) {
                categoryBaseResponse.data = category.get()
            } else {
                categoryBaseResponse.errorResponse = ErrorResponse().getErrorResponse(100, msg_no_category_found)

            }
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            categoryBaseResponse.errorResponse = ErrorResponse().getErrorResponse(100, msg_no_category_found)
        }
        return categoryBaseResponse
    }

    @PostMapping(ENDPOINT_CATEGORY_SAVE)
    fun saveCategory(@RequestBody saveCategory: CategoryMaster): BaseResponse<CommonResponse> {
        val saveCategoryBaseResponse = BaseResponse<CommonResponse>()
        var categoryValidatorPair = saveCategory.nameValid()
        if (categoryValidatorPair.first) {
            val categoryMaster = categoryMasterRepo?.findByName(saveCategory.name)
            if (categoryMaster == null) {
                // type is not exist
                try {
                    categoryMasterRepo?.save(saveCategory)
                    println(msg_category_saved)
                    saveCategoryBaseResponse.data = CommonResponse().getCommonResponse(msg_category_saved)
                } catch (e: Exception) {
                    e.printStackTrace()
                    println(e.localizedMessage)
                    val errorResponse = ErrorResponse().getErrorResponse(0, e.localizedMessage)
                    saveCategoryBaseResponse.errorResponse = errorResponse
                }
            } else {
                // type is exist
                println(msg_category_exist)
                val errorResponse = ErrorResponse().getErrorResponse(100, msg_category_exist)
                saveCategoryBaseResponse.errorResponse = errorResponse
            }
        } else {
            val errorResponse = ErrorResponse().getErrorResponse(100, categoryValidatorPair.second)
            saveCategoryBaseResponse.errorResponse = errorResponse
        }
        return saveCategoryBaseResponse
    }

    @PutMapping(ENDPOINT_CATEGORY_UPDATE)
    fun updateCategory(@RequestBody updateCategory: CategoryMaster): BaseResponse<CommonResponse> {
        val updateCateogryBaseResponse = BaseResponse<CommonResponse>()
        var typeValidatorPair = updateCategory.nameValid()
        if (typeValidatorPair.first) {
            val categoryMaster = categoryMasterRepo?.findByName(updateCategory.name)
            if (categoryMaster == null) {
                // type is not exist
                try {
                    categoryMasterRepo?.save(updateCategory)
                    println(msg_category_updated)
                    updateCateogryBaseResponse.data = CommonResponse().getCommonResponse(msg_category_updated)
                } catch (e: Exception) {
                    e.printStackTrace()
                    println(e.localizedMessage)
                    val errorResponse = ErrorResponse().getErrorResponse(0, e.localizedMessage)
                    updateCateogryBaseResponse.errorResponse = errorResponse
                }
            } else {
                // type is exist
                if (updateCategory.id.equals(categoryMaster.id)) {
                    updateCateogryBaseResponse.data = CommonResponse().getCommonResponse(msg_no_change_updated)
                } else {
                    val errorResponse = ErrorResponse().getErrorResponse(100, msg_category_exist)
                    updateCateogryBaseResponse.errorResponse = errorResponse
                }

            }
        } else {
            val errorResponse = ErrorResponse().getErrorResponse(100, typeValidatorPair.second)
            updateCateogryBaseResponse.errorResponse = errorResponse
        }
        return updateCateogryBaseResponse
    }

    @PostMapping(ENDPOINT_CATEGORY_DELETE)
    fun deleteCategory(@RequestBody deleteCategoryMaster: CategoryMaster): BaseResponse<CommonResponse> {
        val deleteCommonBaseResponse = BaseResponse<CommonResponse>()
        var categoryValidatorPair = deleteCategoryMaster.idValid()
        if (categoryValidatorPair.first) {
            val userTypeMasterOptional = categoryMasterRepo?.findById(deleteCategoryMaster.id)
            if (!userTypeMasterOptional?.isEmpty!!) {
                // type is not exist
                try {
                    val userTypeMaster = userTypeMasterOptional.get()
                    userTypeMaster.isDeleted = true
                    categoryMasterRepo?.save(userTypeMaster)
                    println(msg_category_deleted)
                    deleteCommonBaseResponse.data = CommonResponse().getCommonResponse(msg_category_deleted)
                } catch (e: Exception) {
                    e.printStackTrace()
                    println("${e.localizedMessage}")
                    val errorResponse = ErrorResponse().getErrorResponse(0, e.localizedMessage)
                    deleteCommonBaseResponse.errorResponse = errorResponse
                }
            } else {
                // type is exist
                val errorResponse = ErrorResponse().getErrorResponse(100, msg_user_type_exist)
                deleteCommonBaseResponse.errorResponse = errorResponse
            }
        } else {
            val errorResponse = ErrorResponse().getErrorResponse(100, categoryValidatorPair.second)
            deleteCommonBaseResponse.errorResponse = errorResponse
        }
        return deleteCommonBaseResponse
    }

    @GetMapping(ENDPOINT_MASTER_USERTYPE)
    fun getUserTypes(): BaseResponse<MutableList<UserTypeMaster>> {
        val userTypeBaseResponse = BaseResponse<MutableList<UserTypeMaster>>()
        val userTypesList = userTypeRepo?.findAll()
        if (userTypesList.isNullOrEmpty()) {
            userTypeBaseResponse.errorResponse = ErrorResponse().getErrorResponse(100, msg_no_users_found)
        } else {
            userTypeBaseResponse.data = userTypesList
        }
        return userTypeBaseResponse
    }

    @GetMapping(ENDPOINT_USERTYPE_GET)
    fun getUserTypeByName(@PathVariable("type") type: String): BaseResponse<UserTypeMaster> {
        val userTypeMasterBaseResponse = BaseResponse<UserTypeMaster>()
        val userTypeMaster = userTypeRepo?.findByType(type)
        if (userTypeMaster != null) {
            userTypeMasterBaseResponse.data = userTypeMaster
        } else {
            userTypeMasterBaseResponse.errorResponse = ErrorResponse().getErrorResponse(0, msg_no_user_type_found)
        }
        return userTypeMasterBaseResponse
    }

    @PostMapping(ENDPOINT_USERTYPE_SAVE)
    fun saveUserType(@RequestBody saveUserTypeMaster: UserTypeMaster): BaseResponse<CommonResponse> {
        val saveUserTypeBaseResponse = BaseResponse<CommonResponse>()
        var typeValidatorPair = saveUserTypeMaster.typeValid()
        if (typeValidatorPair.first) {
            val userTypeMaster = userTypeRepo?.findByType(saveUserTypeMaster.type)
            if (userTypeMaster == null) {
                // type is not exist
                try {
                    userTypeRepo?.save(saveUserTypeMaster)
                    println("$msg_user_type_saved")
                    saveUserTypeBaseResponse.data = CommonResponse().getCommonResponse(msg_user_type_saved)
                } catch (e: Exception) {
                    e.printStackTrace()
                    println("${e.localizedMessage}")
                    val errorResponse = ErrorResponse().getErrorResponse(0, e.localizedMessage)
                    saveUserTypeBaseResponse.errorResponse = errorResponse
                }
            } else {
                // type is exist
                println("$msg_user_type_exist")
                val errorResponse = ErrorResponse().getErrorResponse(100, msg_user_type_exist)
                saveUserTypeBaseResponse.errorResponse = errorResponse
            }
        } else {
            val errorResponse = ErrorResponse().getErrorResponse(100, typeValidatorPair.second)
            saveUserTypeBaseResponse.errorResponse = errorResponse
        }
        return saveUserTypeBaseResponse
    }

    @PutMapping(ENDPOINT_USERTYPE_UPDATE)
    fun updateUserType(@RequestBody updateUserTypeMaster: UserTypeMaster): BaseResponse<CommonResponse> {
        val updateUserTypeBaseResponse = BaseResponse<CommonResponse>()
        var typeValidatorPair = updateUserTypeMaster.typeValid()
        if (typeValidatorPair.first) {
            val userTypeMaster = userTypeRepo?.findByType(updateUserTypeMaster.type)
            if (userTypeMaster == null) {
                // type is not exist
                try {
                    userTypeRepo?.save(updateUserTypeMaster)
                    println("$msg_user_type_updated")
                    updateUserTypeBaseResponse.data = CommonResponse().getCommonResponse(msg_user_type_updated)
                } catch (e: Exception) {
                    e.printStackTrace()
                    println("${e.localizedMessage}")
                    val errorResponse = ErrorResponse().getErrorResponse(0, e.localizedMessage)
                    updateUserTypeBaseResponse.errorResponse = errorResponse
                }
            } else {
                // type is exist
                if (updateUserTypeMaster.id.equals(userTypeMaster.id)) {
                    updateUserTypeBaseResponse.data = CommonResponse().getCommonResponse(msg_no_change_updated)
                } else {
                    val errorResponse = ErrorResponse().getErrorResponse(100, msg_user_type_exist)
                    updateUserTypeBaseResponse.errorResponse = errorResponse
                }
            }
        } else {
            val errorResponse = ErrorResponse().getErrorResponse(100, typeValidatorPair.second)
            updateUserTypeBaseResponse.errorResponse = errorResponse
        }
        return updateUserTypeBaseResponse
    }

    @PostMapping(ENDPOINT_USERTYPE_DELETE)
    fun deleteUserType(@RequestBody deleteUserTypeMaster: UserTypeMaster): BaseResponse<CommonResponse> {
        val deleteCommonBaseResponse = BaseResponse<CommonResponse>()
        var typeValidatorPair = deleteUserTypeMaster.typeValid()
        if (typeValidatorPair.first) {
            val userTypeMaster = userTypeRepo?.findByType(deleteUserTypeMaster.type)
            if (userTypeMaster != null) {
                // type is not exist
                try {
                    deleteUserTypeMaster.isDeleted = true
                    userTypeRepo?.save(deleteUserTypeMaster)
                    println(msg_user_type_deleted)
                    deleteCommonBaseResponse.data = CommonResponse().getCommonResponse(msg_user_type_updated)
                } catch (e: Exception) {
                    e.printStackTrace()
                    println("${e.localizedMessage}")
                    val errorResponse = ErrorResponse().getErrorResponse(0, e.localizedMessage)
                    deleteCommonBaseResponse.errorResponse = errorResponse
                }
            } else {
                // type is exist
                val errorResponse = ErrorResponse().getErrorResponse(100, msg_user_type_exist)
                deleteCommonBaseResponse.errorResponse = errorResponse
            }
        } else {
            val errorResponse = ErrorResponse().getErrorResponse(100, typeValidatorPair.second)
            deleteCommonBaseResponse.errorResponse = errorResponse
        }
        return deleteCommonBaseResponse
    }

}