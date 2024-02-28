package com.example.democrud.controller

import com.example.democrud.dto.NoticeDto
import com.example.democrud.dto.NoticeResponse
import com.example.democrud.model.Notice
import com.example.democrud.service.NoticeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
class NoticeController @Autowired constructor(val noticeService: NoticeService) {

    @PostMapping("/save")
    fun save(@RequestBody noticeDto: NoticeDto) {
        noticeService.save(noticeDto)
    }

    @PatchMapping("/update/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody noticeDto: NoticeDto
    ) {
        noticeService.update(noticeDto, id)
    }

    @GetMapping("/get/{id}")
    fun get(
        @PathVariable id: Long
    ): Notice {
        return noticeService.getById(id)
    }

    @GetMapping("/get/all")
    fun getAll(): NoticeResponse {
        return noticeService.getByAllId()
    }

    @DeleteMapping("delete/{id}")
    fun delete(@PathVariable id: Long) {
        noticeService.delete(id)
    }
}