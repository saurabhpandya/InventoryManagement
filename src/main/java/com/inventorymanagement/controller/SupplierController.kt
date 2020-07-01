package com.inventorymanagement.controller

import com.inventorymanagement.constants.ApiConstants
import com.inventorymanagement.constants.Constants
import com.inventorymanagement.extension.getCommonResponse
import com.inventorymanagement.extension.getErrorResponse
import com.inventorymanagement.extension.idValid
import com.inventorymanagement.model.SupplierMaster
import com.inventorymanagement.model.base.BaseResponse
import com.inventorymanagement.model.base.CommonResponse
import com.inventorymanagement.model.base.ErrorResponse
import com.inventorymanagement.repository.SupplierMasterRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(ApiConstants.API_V1_SUPPLIER)
class SupplierController {

    @Autowired
    private val supplierMasterRepo: SupplierMasterRepository? = null

    @GetMapping(ApiConstants.ENDPOINT_SUPPLIER)
    fun getAllSuppliers(): BaseResponse<MutableList<SupplierMaster>> {
        val supplierListBaseResponse = BaseResponse<MutableList<SupplierMaster>>()
        val supplierList = supplierMasterRepo?.findAll()
        if (supplierList.isNullOrEmpty()) {
            supplierListBaseResponse.errorResponse = ErrorResponse().getErrorResponse(100, Constants.msg_no_supplier_found)
        } else {
            supplierListBaseResponse.data = supplierList
        }
        return supplierListBaseResponse
    }

    @GetMapping(ApiConstants.ENDPOINT_SUPPLIER_GET)
    fun getSupplierById(@PathVariable("id") id: Int): BaseResponse<SupplierMaster> {
        val supplierBaseResponse = BaseResponse<SupplierMaster>()
        try {
            val supplierOptional = supplierMasterRepo?.findById(id)
            if (!supplierOptional?.isEmpty!!) {
                supplierBaseResponse.data = supplierOptional.get()
            } else {
                supplierBaseResponse.errorResponse = ErrorResponse().getErrorResponse(100, Constants.msg_no_supplier_found)
            }
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            supplierBaseResponse.errorResponse = ErrorResponse().getErrorResponse(100, Constants.msg_no_supplier_found)
        }
        return supplierBaseResponse
    }

    @PostMapping(ApiConstants.ENDPOINT_SUPPLIER_SAVE)
    fun saveSupplier(@RequestBody saveSupplierMaster: SupplierMaster): BaseResponse<CommonResponse> {
        val saveSupplierBaseResponse = BaseResponse<CommonResponse>()
        try {
            supplierMasterRepo?.save(saveSupplierMaster)
            saveSupplierBaseResponse.data = CommonResponse().getCommonResponse(Constants.msg_supplier_saved)
        } catch (e: Exception) {
            e.printStackTrace()
            println(e.localizedMessage)
            val errorResponse = ErrorResponse().getErrorResponse(0, e.localizedMessage)
            saveSupplierBaseResponse.errorResponse = errorResponse
        }
        return saveSupplierBaseResponse
    }

    @PutMapping(ApiConstants.ENDPOINT_SUPPLIER_UPDATE)
    fun updateSupplier(@RequestBody updateSupplierMaster: SupplierMaster): BaseResponse<CommonResponse> {
        val updateSupplierBaseResponse = BaseResponse<CommonResponse>()

        val supplierMasterOptional = supplierMasterRepo?.findById(updateSupplierMaster.id)
        if (supplierMasterOptional == null) {
            // type is not exist
            try {
                supplierMasterRepo?.save(updateSupplierMaster)
                updateSupplierBaseResponse.data = CommonResponse().getCommonResponse(Constants.msg_supplier_updated)
            } catch (e: Exception) {
                e.printStackTrace()
                println(e.localizedMessage)
                val errorResponse = ErrorResponse().getErrorResponse(0, e.localizedMessage)
                updateSupplierBaseResponse.errorResponse = errorResponse
            }
        } else {
            // type is exist
            if (updateSupplierMaster.id.equals(supplierMasterOptional.get().id)) {
                updateSupplierBaseResponse.data = CommonResponse().getCommonResponse(Constants.msg_no_change_updated)
            } else {
                val errorResponse = ErrorResponse().getErrorResponse(100, Constants.msg_supplier_exist)
                updateSupplierBaseResponse.errorResponse = errorResponse
            }
        }
        return updateSupplierBaseResponse
    }

    @PostMapping(ApiConstants.ENDPOINT_SUPPLIER_DELETE)
    fun deleteSupplier(@RequestBody deleteSupplierMaster: SupplierMaster): BaseResponse<CommonResponse> {
        val deleteCommonBaseResponse = BaseResponse<CommonResponse>()
        var supplierValidatorPair = deleteSupplierMaster.idValid()
        if (supplierValidatorPair.first) {
            val supplierMasterOptional = supplierMasterRepo?.findById(deleteSupplierMaster.id)
            if (!supplierMasterOptional?.isEmpty!!) {
                // type is not exist
                try {
                    val supplierMaster = supplierMasterOptional.get()
                    supplierMaster.isDeleted = true
                    supplierMasterRepo?.save(supplierMaster)
                    deleteCommonBaseResponse.data = CommonResponse().getCommonResponse(Constants.msg_supplier_deleted)
                } catch (e: Exception) {
                    e.printStackTrace()
                    val errorResponse = ErrorResponse().getErrorResponse(0, e.localizedMessage)
                    deleteCommonBaseResponse.errorResponse = errorResponse
                }
            } else {
                // type is exist
                val errorResponse = ErrorResponse().getErrorResponse(100, Constants.msg_supplier_exist)
                deleteCommonBaseResponse.errorResponse = errorResponse
            }
        } else {
            val errorResponse = ErrorResponse().getErrorResponse(100, supplierValidatorPair.second)
            deleteCommonBaseResponse.errorResponse = errorResponse
        }
        return deleteCommonBaseResponse
    }

}