package com.lmar.demo_rabbitmq_consumer.service;

import com.lmar.demo_rabbitmq_consumer.config.RabbitMQConfig;
import com.lmar.demo_rabbitmq_consumer.model.Models;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConsumerListeners {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_SHAPE)
    public void readShapeMessage(Models.Shape shape) {
        log.info("Receiving shape: {}", shape);
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_COLOR)
    public void readColorMessage(Models.Color color) {
        log.info("Receiving color: {}", color);
    }
}
