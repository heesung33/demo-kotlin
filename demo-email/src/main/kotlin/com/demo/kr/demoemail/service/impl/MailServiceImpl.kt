package com.demo.kr.demoemail.service.impl

import com.demo.kr.demoemail.service.MailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class MailServiceImpl @Autowired constructor(
    private val mailSender: JavaMailSender,
    @Value("\${spring.mail.username}") private val myName: String
) : MailService {
    override fun sendSimpleMail(to: String, subject: String, content: String) {
        val message = SimpleMailMessage().apply {
            from = myName
            setTo(to)
            setSubject(subject)
            text = content
        }
        mailSender.send(message)
    }
}