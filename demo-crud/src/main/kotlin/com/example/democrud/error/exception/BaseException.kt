package com.example.democrud.error.exception

import com.example.democrud.error.message.ErrorCode

class BaseException(errorCode: ErrorCode): RuntimeException() {
    public val errorCode: ErrorCode = errorCode
}