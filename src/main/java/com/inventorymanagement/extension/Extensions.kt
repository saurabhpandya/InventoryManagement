package com.inventorymanagement.extension

import com.inventorymanagement.model.UserTypeMaster
import com.inventorymanagement.model.base.CommonResponse
import com.inventorymanagement.model.base.ErrorResponse

private val nullOrEmpty = "Please enter some data"

fun UserTypeMaster.typeValid(): Pair<Boolean, String> {
    var isUserTypeValid = false
    var errorMsg = ""
    if (!this.type.isNullOrEmpty()) {
        isUserTypeValid = true
    } else {
        errorMsg = nullOrEmpty
    }
    return Pair(isUserTypeValid, errorMsg)
}

fun ErrorResponse.getErrorResponse(errorCode: Int, errorMsg: String): ErrorResponse {
    val errorResponse = ErrorResponse()
    errorResponse.errorCode = errorCode
    errorResponse.errorMessage = errorMsg
    return errorResponse
}

fun CommonResponse.getCommonResponse(message: String): CommonResponse{
    val commonResponse = CommonResponse()
    commonResponse.message = message
    return commonResponse
}