package com.demo.kr.demoemail.service.impl

import com.demo.kr.demoemail.service.MailService
import jakarta.mail.internet.MimeMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service
import cn.hutool.core.util.ArrayUtil;
import org.springframework.core.io.FileSystemResource
import java.io.File

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

    override fun sendFileMail(to: String, subject: String, content: String, filePath: String, cc: String) {
        val message: MimeMessage = mailSender.createMimeMessage()
        val helper = MimeMessageHelper(message, true)
        helper.setFrom(myName)
        helper.setTo(to)
        helper.setSubject(subject)
        helper.setText(content, true);
        if (ArrayUtil.isNotEmpty(cc)) {
            helper.setCc(cc)
        }
        val fileName: String = filePath.substring(filePath.lastIndexOf(File.separator))
        helper.addAttachment(fileName, FileSystemResource(File(filePath)))
        mailSender.send(message)
    }
}