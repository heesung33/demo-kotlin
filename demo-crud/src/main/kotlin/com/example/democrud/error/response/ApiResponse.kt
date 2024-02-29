package com.example.democrud.error.response

import com.example.democrud.error.message.ErrorCode

data class ApiResponse(
    var status: Int,
    var resultCode: String,
    var resultMsg: String
) {
    constructor(errorCode: ErrorCode) : this(errorCode.status, errorCode.divisionCode, errorCode.message) {
    }
}
