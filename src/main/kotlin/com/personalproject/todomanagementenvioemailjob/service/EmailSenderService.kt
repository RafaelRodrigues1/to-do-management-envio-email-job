package com.personalproject.todomanagementenvioemailjob.service

import com.personalproject.todomanagementenvioemailjob.model.Email
import jakarta.mail.internet.MimeMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Component

@Component
class EmailSenderService {

    @Autowired
    private lateinit var emailSender: JavaMailSender

    fun send(email: Email) {
        val message: MimeMessage = emailSender.createMimeMessage()
        val helper = MimeMessageHelper(message, "utf-8")
        helper.setSubject(email.title)
        helper.setText(email.text, true)
        helper.setTo(email.receiver!!.email)
        emailSender.send(message)
    }
}
