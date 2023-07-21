package com.personalproject.todomanagementenvioemailjob.configuration

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMQConfig {

    @Value("\${spring.rabbitmq.addresses}")
    private lateinit var addresses: String

    @Value("\${rabbitmq.queue}")
    private lateinit var queueName: String

    @Value("\${rabbitmq.concurrent.consumers}")
    private lateinit var concurrentConsumers: Integer

    @Value("\${rabbitmq.max.concurrent.consumers}")
    private lateinit var maxConcurrentConsumers: Integer

    @Bean
    fun queue(): Queue? {
        return Queue(queueName, true)
    }

    @Bean
    fun jsonMessageConverter(): MessageConverter? {
        val objectMapper = ObjectMapper()
        return Jackson2JsonMessageConverter(objectMapper)
    }

    @Bean
    fun connectionFactory(): ConnectionFactory? {
        val connectionFactory = CachingConnectionFactory()
        connectionFactory.setUri(addresses)
        return connectionFactory
    }

    @Bean
    fun rabbitListenerContainerFactory(): SimpleRabbitListenerContainerFactory? {
        val factory = SimpleRabbitListenerContainerFactory()
        factory.setConnectionFactory(connectionFactory())
        factory.setMessageConverter(jsonMessageConverter())
        factory.setConcurrentConsumers(concurrentConsumers.toInt())
        factory.setMaxConcurrentConsumers(maxConcurrentConsumers.toInt())
        return factory
    }
}
