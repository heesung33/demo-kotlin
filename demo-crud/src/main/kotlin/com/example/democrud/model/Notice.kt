package com.example.democrud.model

import com.example.democrud.dto.NoticeDto
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Notice(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var writer: String,
    var password: String,
    var title: String,
    var content: String
) {
    fun updateNotice(noticeDto: NoticeDto) {
        this.writer = noticeDto.writer
        this.content = noticeDto.content
        this.title = noticeDto.title
        this.password = noticeDto.password
    }
}