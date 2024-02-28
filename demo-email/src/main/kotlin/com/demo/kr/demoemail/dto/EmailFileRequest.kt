package com.demo.kr.demoemail.dto

data class EmailFileRequest(
    val to: String,
    val subject: String,
    val content: String,
    val cc: String?
)
