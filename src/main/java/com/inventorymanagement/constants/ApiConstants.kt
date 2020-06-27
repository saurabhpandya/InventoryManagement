package com.inventorymanagement.constants

class ApiConstants {

    companion object {
        const val API_V1_MASTER = "master/api/v1"
        const val ENDPOINT_MASTER_USERTYPE = "userType"
        const val ENDPOINT_USERTYPE_GET = "$ENDPOINT_MASTER_USERTYPE/{type}"
        const val ENDPOINT_USERTYPE_SAVE = "$ENDPOINT_MASTER_USERTYPE/saveUserType"
        const val ENDPOINT_USERTYPE_UPDATE = "$ENDPOINT_MASTER_USERTYPE/udpateUserType"
        const val ENDPOINT_USERTYPE_DELETE = "$ENDPOINT_MASTER_USERTYPE/deleteUserType"
    }

}