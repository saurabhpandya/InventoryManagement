package com.inventorymanagement.controller

import com.inventorymanagement.constants.ApiConstants
import com.inventorymanagement.constants.ApiConstants.Companion.API_V1_CUSTOMER
import com.inventorymanagement.constants.Constants
import com.inventorymanagement.extension.getCommonResponse
import com.inventorymanagement.extension.getErrorResponse
import com.inventorymanagement.extension.idValid
import com.inventorymanagement.model.CustomerMaster
import com.inventorymanagement.model.LocationMapping
import com.inventorymanagement.model.base.BaseResponse
import com.inventorymanagement.model.base.CommonResponse
import com.inventorymanagement.model.base.ErrorResponse
import com.inventorymanagement.repository.CustomerMasterRepository
import com.inventorymanagement.repository.LocationMappingRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(API_V1_CUSTOMER)
class CustomerController {

    @Autowired
    private val customerMasterRepo: CustomerMasterRepository? = null

    @Autowired
    private val locationMappingRepo: LocationMappingRepository? = null

    @GetMapping(ApiConstants.ENDPOINT_LOCATION)
    fun getAllLocation(): BaseResponse<MutableList<LocationMapping>> {
        val locationMappingListBaseResponse = BaseResponse<MutableList<LocationMapping>>()
        val locationMappingList = locationMappingRepo?.findAll()
        if (locationMappingList.isNullOrEmpty()) {
            locationMappingListBaseResponse.errorResponse = ErrorResponse().getErrorResponse(100, Constants.msg_no_location_found)
        } else {
            locationMappingListBaseResponse.data = locationMappingList
        }
        return locationMappingListBaseResponse
    }

    @GetMapping(ApiConstants.ENDPOINT_LOCATION_GET)
    fun getLocationById(@PathVariable("id") id: Int): BaseResponse<LocationMapping> {
        val locationMappingBaseResponse = BaseResponse<LocationMapping>()
        try {
            val locationMapping = locationMappingRepo?.findById(id)
            if (!locationMapping?.isEmpty!!) {
                locationMappingBaseResponse.data = locationMapping.get()
            } else {
                locationMappingBaseResponse.errorResponse = ErrorResponse().getErrorResponse(100, Constants.msg_no_location_found)
            }
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            locationMappingBaseResponse.errorResponse = ErrorResponse().getErrorResponse(100, Constants.msg_no_location_found)
        }
        return locationMappingBaseResponse
    }

    @PostMapping(ApiConstants.ENDPOINT_LOCATION_SAVE)
    fun saveLocation(@RequestBody saveLocationMapping: LocationMapping): BaseResponse<CommonResponse> {
        val saveLocationMappingBaseResponse = BaseResponse<CommonResponse>()
        try {
            locationMappingRepo?.save(saveLocationMapping)
            saveLocationMappingBaseResponse.data = CommonResponse().getCommonResponse(Constants.msg_location_saved)
        } catch (e: Exception) {
            e.printStackTrace()
            println(e.localizedMessage)
            val errorResponse = ErrorResponse().getErrorResponse(0, e.localizedMessage)
            saveLocationMappingBaseResponse.errorResponse = errorResponse
        }
        return saveLocationMappingBaseResponse
    }

    @PutMapping(ApiConstants.ENDPOINT_LOCATION_UPDATE)
    fun updateLocation(@RequestBody updateLocationMapping: LocationMapping): BaseResponse<CommonResponse> {
        val updateLocationMappingBaseResponse = BaseResponse<CommonResponse>()

        val locationMapping = locationMappingRepo?.findById(updateLocationMapping.id)
        if (locationMapping == null) {
            // type is not exist
            try {
                locationMappingRepo?.save(updateLocationMapping)
                updateLocationMappingBaseResponse.data = CommonResponse().getCommonResponse(Constants.msg_location_updated)
            } catch (e: Exception) {
                e.printStackTrace()
                println(e.localizedMessage)
                val errorResponse = ErrorResponse().getErrorResponse(0, e.localizedMessage)
                updateLocationMappingBaseResponse.errorResponse = errorResponse
            }
        } else {
            // type is exist
            if (updateLocationMapping.id.equals(locationMapping.get().id)) {
                updateLocationMappingBaseResponse.data = CommonResponse().getCommonResponse(Constants.msg_no_change_updated)
            } else {
                val errorResponse = ErrorResponse().getErrorResponse(100, Constants.msg_location_exist)
                updateLocationMappingBaseResponse.errorResponse = errorResponse
            }
        }
        return updateLocationMappingBaseResponse
    }

    @PostMapping(ApiConstants.ENDPOINT_LOCATION_DELETE)
    fun deleteLocation(@RequestBody deleteLocationMapping: LocationMapping): BaseResponse<CommonResponse> {
        val deleteCommonBaseResponse = BaseResponse<CommonResponse>()
        var locationValidatorPair = deleteLocationMapping.idValid()
        if (locationValidatorPair.first) {
            val locationMappingOptional = locationMappingRepo?.findById(deleteLocationMapping.id)
            if (!locationMappingOptional?.isEmpty!!) {
                // type is not exist
                try {
                    val locationMapping = locationMappingOptional.get()
                    locationMapping.isDeleted = true
                    locationMappingRepo?.save(locationMapping)
                    deleteCommonBaseResponse.data = CommonResponse().getCommonResponse(Constants.msg_location_deleted)
                } catch (e: Exception) {
                    e.printStackTrace()
                    val errorResponse = ErrorResponse().getErrorResponse(0, e.localizedMessage)
                    deleteCommonBaseResponse.errorResponse = errorResponse
                }
            } else {
                // type is exist
                val errorResponse = ErrorResponse().getErrorResponse(100, Constants.msg_location_exist)
                deleteCommonBaseResponse.errorResponse = errorResponse
            }
        } else {
            val errorResponse = ErrorResponse().getErrorResponse(100, locationValidatorPair.second)
            deleteCommonBaseResponse.errorResponse = errorResponse
        }
        return deleteCommonBaseResponse
    }

    @GetMapping(ApiConstants.ENDPOINT_CUSTOMER)
    fun getAllCustomers(): BaseResponse<MutableList<CustomerMaster>> {
        val customerListBaseResponse = BaseResponse<MutableList<CustomerMaster>>()
        val customerList = customerMasterRepo?.findAll()
        if (customerList.isNullOrEmpty()) {
            customerListBaseResponse.errorResponse = ErrorResponse().getErrorResponse(100, Constants.msg_no_customer_found)
        } else {
            customerListBaseResponse.data = customerList
        }
        return customerListBaseResponse
    }

    @GetMapping(ApiConstants.ENDPOINT_CUSTOMER_GET)
    fun getCustomerById(@PathVariable("id") id: Int): BaseResponse<CustomerMaster> {
        val customerBaseResponse = BaseResponse<CustomerMaster>()
        try {
            val customerOptional = customerMasterRepo?.findById(id)
            if (!customerOptional?.isEmpty!!) {
                customerBaseResponse.data = customerOptional.get()
            } else {
                customerBaseResponse.errorResponse = ErrorResponse().getErrorResponse(100, Constants.msg_no_customer_found)
            }
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            customerBaseResponse.errorResponse = ErrorResponse().getErrorResponse(100, Constants.msg_no_customer_found)
        }
        return customerBaseResponse
    }

    @PostMapping(ApiConstants.ENDPOINT_CUSTOMER_SAVE)
    fun saveCustomer(@RequestBody saveCustomerMaster: CustomerMaster): BaseResponse<CommonResponse> {
        val saveCustomerBaseResponse = BaseResponse<CommonResponse>()
        try {
            customerMasterRepo?.save(saveCustomerMaster)
            saveCustomerBaseResponse.data = CommonResponse().getCommonResponse(Constants.msg_customer_saved)
        } catch (e: Exception) {
            e.printStackTrace()
            println(e.localizedMessage)
            val errorResponse = ErrorResponse().getErrorResponse(0, e.localizedMessage)
            saveCustomerBaseResponse.errorResponse = errorResponse
        }
        return saveCustomerBaseResponse
    }

    @PutMapping(ApiConstants.ENDPOINT_CUSTOMER_UPDATE)
    fun updateCustomer(@RequestBody updateCustomerMaster: CustomerMaster): BaseResponse<CommonResponse> {
        val updateCustomerBaseResponse = BaseResponse<CommonResponse>()

        val customerMasterOptional = customerMasterRepo?.findById(updateCustomerMaster.id)
        if (customerMasterOptional == null) {
            // type is not exist
            try {
                customerMasterRepo?.save(updateCustomerMaster)
                updateCustomerBaseResponse.data = CommonResponse().getCommonResponse(Constants.msg_customer_updated)
            } catch (e: Exception) {
                e.printStackTrace()
                println(e.localizedMessage)
                val errorResponse = ErrorResponse().getErrorResponse(0, e.localizedMessage)
                updateCustomerBaseResponse.errorResponse = errorResponse
            }
        } else {
            // type is exist
            if (updateCustomerMaster.id.equals(customerMasterOptional.get().id)) {
                updateCustomerBaseResponse.data = CommonResponse().getCommonResponse(Constants.msg_no_change_updated)
            } else {
                val errorResponse = ErrorResponse().getErrorResponse(100, Constants.msg_customer_exist)
                updateCustomerBaseResponse.errorResponse = errorResponse
            }
        }
        return updateCustomerBaseResponse
    }

    @PostMapping(ApiConstants.ENDPOINT_CUSTOMER_DELETE)
    fun deleteCustomer(@RequestBody deleteCustomerMaster: CustomerMaster): BaseResponse<CommonResponse> {
        val deleteCommonBaseResponse = BaseResponse<CommonResponse>()
        var customerValidatorPair = deleteCustomerMaster.idValid()
        if (customerValidatorPair.first) {
            val customerMasterOptional = customerMasterRepo?.findById(deleteCustomerMaster.id)
            if (!customerMasterOptional?.isEmpty!!) {
                // type is not exist
                try {
                    val customerMaster = customerMasterOptional.get()
                    customerMaster.isDeleted = true
                    customerMasterRepo?.save(customerMaster)
                    deleteCommonBaseResponse.data = CommonResponse().getCommonResponse(Constants.msg_customer_deleted)
                } catch (e: Exception) {
                    e.printStackTrace()
                    val errorResponse = ErrorResponse().getErrorResponse(0, e.localizedMessage)
                    deleteCommonBaseResponse.errorResponse = errorResponse
                }
            } else {
                // type is exist
                val errorResponse = ErrorResponse().getErrorResponse(100, Constants.msg_customer_exist)
                deleteCommonBaseResponse.errorResponse = errorResponse
            }
        } else {
            val errorResponse = ErrorResponse().getErrorResponse(100, customerValidatorPair.second)
            deleteCommonBaseResponse.errorResponse = errorResponse
        }
        return deleteCommonBaseResponse
    }

}