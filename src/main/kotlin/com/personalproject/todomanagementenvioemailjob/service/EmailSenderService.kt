package com.personalproject.todomanagementenvioemailjob.service

import com.personalproject.todomanagementenvioemailjob.model.Email
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.MailSender
import org.springframework.mail.SimpleMailMessage
import org.springframework.stereotype.Component

@Component
class EmailSenderService {

    @Autowired
    private lateinit var emailSender: MailSender

    fun send(email: Email) {
        val message: SimpleMailMessage = SimpleMailMessage()
        message.subject = email.title
        message.text = email.text
        message.setTo(email.receiver?.email)
        emailSender.send(message)
    }
}
