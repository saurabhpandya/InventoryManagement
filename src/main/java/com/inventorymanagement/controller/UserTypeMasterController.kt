package com.inventorymanagement.controller

import com.inventorymanagement.constants.ApiConstants.Companion.API_V1_MASTER
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_MASTER_USERTYPE
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_USERTYPE_DELETE
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_USERTYPE_GET
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_USERTYPE_SAVE
import com.inventorymanagement.constants.ApiConstants.Companion.ENDPOINT_USERTYPE_UPDATE
import com.inventorymanagement.constants.Constants.Companion.msg_no_user_type_found
import com.inventorymanagement.constants.Constants.Companion.msg_no_users_found
import com.inventorymanagement.constants.Constants.Companion.msg_user_type_exist
import com.inventorymanagement.constants.Constants.Companion.msg_user_type_saved
import com.inventorymanagement.constants.Constants.Companion.msg_user_type_updated
import com.inventorymanagement.extension.getCommonResponse
import com.inventorymanagement.extension.getErrorResponse
import com.inventorymanagement.extension.typeValid
import com.inventorymanagement.model.UserTypeMaster
import com.inventorymanagement.model.base.BaseResponse
import com.inventorymanagement.model.base.CommonResponse
import com.inventorymanagement.model.base.ErrorResponse
import com.inventorymanagement.repository.UserTypeMasterRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(API_V1_MASTER)
class UserTypeMasterController {

    @Autowired
    private val userTypeRepo: UserTypeMasterRepository? = null

    @GetMapping(ENDPOINT_MASTER_USERTYPE)
    fun getUserTypes(): BaseResponse<MutableList<UserTypeMaster>> {
        val userTypeBaseResponse = BaseResponse<MutableList<UserTypeMaster>>()
        val userTypesList = userTypeRepo?.findAll()
        if (userTypesList.isNullOrEmpty()) {
            val errorResponse = ErrorResponse()
            errorResponse.errorCode = 100
            errorResponse.errorMessage = msg_no_users_found
            userTypeBaseResponse.errorResponse = errorResponse
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
            userTypeMasterBaseResponse.errorResponse = ErrorResponse()
                    .getErrorResponse(0, msg_no_user_type_found)
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
                val errorResponse = ErrorResponse().getErrorResponse(100, msg_user_type_exist)
                updateUserTypeBaseResponse.errorResponse = errorResponse
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
                    deleteUserTypeMaster.isBlocked = false
                    deleteUserTypeMaster.isDeleted = true
                    userTypeRepo?.save(deleteUserTypeMaster)
                    println("$msg_user_type_updated")
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