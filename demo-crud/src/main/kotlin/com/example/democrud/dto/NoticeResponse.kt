package com.example.democrud.dto

import com.example.democrud.model.Notice

data class NoticeResponse(val total: Long, val noticeList: List<Notice>) {
}
