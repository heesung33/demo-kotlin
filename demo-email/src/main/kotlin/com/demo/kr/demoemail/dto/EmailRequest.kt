package com.demo.kr.demoemail.dto


data class EmailRequest(
    val to:String,
    val subject: String,
    val content: String
)
