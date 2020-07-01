package com.inventorymanagement.extension

import com.inventorymanagement.model.*
import com.inventorymanagement.model.base.CommonResponse
import com.inventorymanagement.model.base.ErrorResponse

private val nullOrEmpty = "Please enter some data"

fun CustomerMaster.idValid(): Pair<Boolean, String> {
    var isIdValid = false
    var errorMsg = ""
    if (this.id > 0) {
        isIdValid = true
    } else {
        errorMsg = nullOrEmpty
    }
    return Pair(isIdValid, errorMsg)
}

fun SupplierMaster.idValid(): Pair<Boolean, String> {
    var isIdValid = false
    var errorMsg = ""
    if (this.id > 0) {
        isIdValid = true
    } else {
        errorMsg = nullOrEmpty
    }
    return Pair(isIdValid, errorMsg)
}

fun OrderMaster.idValid(): Pair<Boolean, String> {
    var isIdValid = false
    var errorMsg = ""
    if (this.id > 0) {
        isIdValid = true
    } else {
        errorMsg = nullOrEmpty
    }
    return Pair(isIdValid, errorMsg)
}

fun LocationMapping.idValid(): Pair<Boolean, String> {
    var isIdValid = false
    var errorMsg = ""
    if (this.id > 0) {
        isIdValid = true
    } else {
        errorMsg = nullOrEmpty
    }
    return Pair(isIdValid, errorMsg)
}

fun CurrencyMaster.idValid(): Pair<Boolean, String> {
    var isIdValid = false
    var errorMsg = ""
    if (this.id > 0) {
        isIdValid = true
    } else {
        errorMsg = nullOrEmpty
    }
    return Pair(isIdValid, errorMsg)
}

fun ProductVariantMapping.idValid(): Pair<Boolean, String> {
    var isIdValid = false
    var errorMsg = ""
    if (this.id > 0) {
        isIdValid = true
    } else {
        errorMsg = nullOrEmpty
    }
    return Pair(isIdValid, errorMsg)
}

fun ProductMaster.nameValid(): Pair<Boolean, String> {
    var isCateogryValid = false
    var errorMsg = ""
    if (!this.name.isNullOrEmpty()) {
        isCateogryValid = true
    } else {
        errorMsg = nullOrEmpty
    }
    return Pair(isCateogryValid, errorMsg)
}

fun ProductMaster.idValid(): Pair<Boolean, String> {
    var isIdValid = false
    var errorMsg = ""
    if (this.id > 0) {
        isIdValid = true
    } else {
        errorMsg = nullOrEmpty
    }
    return Pair(isIdValid, errorMsg)
}

fun SubCategoryMaster.nameValid(): Pair<Boolean, String> {
    var isCateogryValid = false
    var errorMsg = ""
    if (!this.name.isNullOrEmpty()) {
        isCateogryValid = true
    } else {
        errorMsg = nullOrEmpty
    }
    return Pair(isCateogryValid, errorMsg)
}

fun SubCategoryMaster.idValid(): Pair<Boolean, String> {
    var isIdValid = false
    var errorMsg = ""
    if (this.id > 0) {
        isIdValid = true
    } else {
        errorMsg = nullOrEmpty
    }
    return Pair(isIdValid, errorMsg)
}

fun CategoryMaster.nameValid(): Pair<Boolean, String> {
    var isCateogryValid = false
    var errorMsg = ""
    if (!this.name.isNullOrEmpty()) {
        isCateogryValid = true
    } else {
        errorMsg = nullOrEmpty
    }
    return Pair(isCateogryValid, errorMsg)
}

fun CategoryMaster.idValid(): Pair<Boolean, String> {
    var isIdValid = false
    var errorMsg = ""
    if (this.id > 0) {
        isIdValid = true
    } else {
        errorMsg = nullOrEmpty
    }
    return Pair(isIdValid, errorMsg)
}

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

fun CommonResponse.getCommonResponse(message: String): CommonResponse {
    val commonResponse = CommonResponse()
    commonResponse.message = message
    return commonResponse
}