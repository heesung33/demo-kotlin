package com.example.democrud.service

import com.example.democrud.dto.NoticeDto
import com.example.democrud.dto.NoticeResponse
import com.example.democrud.model.Notice
import com.example.democrud.repository.NoticeRepository
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class NoticeService @Autowired constructor(
    val noticeRepository: NoticeRepository,
    val modelMapper: ModelMapper
) {
    fun save(noticeDto: NoticeDto) {
        noticeRepository.save(modelMapper.map(noticeDto, Notice::class.java))
    }

    fun update(noticeDto: NoticeDto, id: Long) {
        val post = noticeRepository.findById(id).get()
        post.updateNotice(noticeDto)
        noticeRepository.save(modelMapper.map(post, Notice::class.java))
    }

    fun getById(id: Long): Notice {
        return noticeRepository.findById(id).get()
    }

    fun getByAllId(): NoticeResponse {
        return NoticeResponse(noticeRepository.count(), noticeRepository.findAll())
    }

    fun delete(id: Long) {
        noticeRepository.deleteById(id)
    }
}