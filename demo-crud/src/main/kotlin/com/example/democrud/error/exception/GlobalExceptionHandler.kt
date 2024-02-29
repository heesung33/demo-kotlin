package com.example.democrud.error.exception

import com.example.democrud.error.message.ErrorCode
import com.example.democrud.error.response.ApiResponse
import com.fasterxml.jackson.core.JsonParseException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.NoHandlerFoundException
import org.springframework.web.servlet.resource.NoResourceFoundException
import java.io.IOException

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(BaseException::class)
    protected fun handleBaseException(e: BaseException): ResponseEntity<ApiResponse> {
        return ResponseEntity.status(e.errorCode.status)
            .body(ApiResponse(e.errorCode.status, e.errorCode.divisionCode, e.errorCode.message))
    }

    @ExceptionHandler(NullPointerException::class)
    protected fun handleNullPointerException(e: NullPointerException): ResponseEntity<ApiResponse> {
        return ResponseEntity.status(HttpStatus.OK).body(
            ApiResponse(
                ErrorCode.NULL_POINT_ERROR.status,
                ErrorCode.NULL_POINT_ERROR.divisionCode,
                ErrorCode.NULL_POINT_ERROR.message
            )
        )
    }

    @ExceptionHandler(IOException::class)
    protected fun handeIoException(e: IOException): ResponseEntity<ApiResponse> {
        return ResponseEntity.status(HttpStatus.OK)
            .body(ApiResponse(ErrorCode.IO_ERROR.status, ErrorCode.IO_ERROR.divisionCode, ErrorCode.IO_ERROR.message))
    }

    @ExceptionHandler(JsonParseException::class)
    protected fun handleJsonParseException(e: JsonParseException): ResponseEntity<ApiResponse> {
        return ResponseEntity.status(HttpStatus.OK).body(
            ApiResponse(
                ErrorCode.JSON_PARSE_ERROR.status,
                ErrorCode.JSON_PARSE_ERROR.divisionCode,
                ErrorCode.JSON_PARSE_ERROR.message
            )
        )
    }
    @ExceptionHandler(NoHandlerFoundException::class)
    protected fun handleNoHandlerFoundException(e: NoHandlerFoundException): ResponseEntity<ApiResponse> {
        return ResponseEntity.status(e.statusCode).body(
            ApiResponse(
                ErrorCode.NOT_FOUND_ERROR.status,
                ErrorCode.NOT_FOUND_ERROR.divisionCode,
                ErrorCode.NOT_FOUND_ERROR.message
            )
        )
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException::class)
    protected fun handleMethodNotAllowedException(e: HttpRequestMethodNotSupportedException): ResponseEntity<ApiResponse> {
        return ResponseEntity.status(e.statusCode).body(
            ApiResponse(
                ErrorCode.METHOD_NOT_ALLOWED_ERROR.status,
                ErrorCode.METHOD_NOT_ALLOWED_ERROR.divisionCode,
                ErrorCode.METHOD_NOT_ALLOWED_ERROR.message
            )
        )
    }
    @ExceptionHandler(Exception::class)
    protected fun handeException(e: Exception): ResponseEntity<ApiResponse> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
            ApiResponse(
                ErrorCode.INTERNAL_SERVER_ERROR.status,
                ErrorCode.INTERNAL_SERVER_ERROR.divisionCode,
                ErrorCode.INTERNAL_SERVER_ERROR.message
            )
        )
    }
}