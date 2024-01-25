package com.demo.kr.demoemail.controller

import com.demo.kr.demoemail.dto.EmailRequest
import com.demo.kr.demoemail.service.MailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class SendController @Autowired constructor(private val mailService: MailService) {
    @PostMapping("/send/email")
    fun sendEmail(@RequestBody emailRequest: EmailRequest) : HashMap<String, Any> {
        val map = HashMap<String, Any>()
        try {
            mailService.sendSimpleMail(emailRequest.to, emailRequest.subject, emailRequest.content)
            map["status"] = "success"
        } catch (e : Exception) {
            map["status"] = "error"
            map["message"] = e.message ?: "An error occurred"
        }
        return map
    }
}