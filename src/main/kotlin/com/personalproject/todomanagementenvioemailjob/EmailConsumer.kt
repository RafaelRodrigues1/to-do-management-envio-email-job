package com.personalproject.todomanagementenvioemailjob

import com.personalproject.todomanagementenvioemailjob.model.Email
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class EmailConsumer {

    @RabbitListener(queues = ["\${rabbitmq.queue}"], )
    fun receiver(email: Email) {
        print(email.receiver?.name)
    }
}
