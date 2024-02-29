package com.example.democrud.error.response

import com.example.democrud.error.message.ErrorCode

data class ApiResponse(
    val status: Int,
    val resultCode: String,
    val resultMsg: String
) {
    constructor(errorCode: ErrorCode) : this(errorCode.status, errorCode.divisionCode, errorCode.message)
}
