package com.example.democrud.error.response

data class ApiResponse<T>(
    val result: T,
    val resultCode: Int,
    val resultMsg: String
)
