package com.inventorymanagement.validator

class Validator {
    private val nullOrEmpty = "Please enter some data"

    fun isNullOrEmpty(str: String?): Pair<Boolean?, String?>? {
        var isValid = false
        var message = ""
        if (str != null && !str.isEmpty()) {
            isValid = true
        } else {
            isValid = false
            message = nullOrEmpty
        }
        return Pair(isValid, message)
    }
}