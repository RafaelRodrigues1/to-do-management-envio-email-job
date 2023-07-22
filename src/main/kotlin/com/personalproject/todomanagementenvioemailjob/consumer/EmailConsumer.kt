package com.personalproject.todomanagementenvioemailjob.consumer

import com.personalproject.todomanagementenvioemailjob.model.Email
import com.personalproject.todomanagementenvioemailjob.service.EmailSenderService
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class EmailConsumer {

    @Autowired
    private lateinit var emailSenderService: EmailSenderService

    @RabbitListener(queues = ["\${rabbitmq.queue}"], )
    fun receiver(email: Email) {
        emailSenderService.send(email)
        print("Email enviado com sucesso: ${email.receiver?.email}")
    }
}
