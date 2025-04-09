package com.lmar.demo_rabbitmq_publisher.controller;

import com.lmar.demo_rabbitmq_publisher.config.RabbitMQConfig;
import com.lmar.demo_rabbitmq_publisher.model.Models;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("publish")
@RequiredArgsConstructor //Inyeción por constructor
public class PublisherController {

    //Ya no va @Autowired -> poner como a las propiedades final
    private final RabbitTemplate template;

    @PostMapping("/shape")
    private String publishColor(@RequestBody Models.Shape shape) {
        this.template.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY_SHAPE, shape);
        return "Shape msg send success";
    }

    @PostMapping("/color")
    private String publishColor(@RequestBody Models.Color color) {
        this.template.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY_COLOR, color);
        return "Color msg send success";
    }
}
