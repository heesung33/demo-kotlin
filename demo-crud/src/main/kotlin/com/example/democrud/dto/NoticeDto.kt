package com.example.democrud.dto

data class NoticeDto(
    val writer: String,
    val password: String,
    var title: String,
    var content: String
) {
}
