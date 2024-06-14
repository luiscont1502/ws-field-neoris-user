package com.neoris.service.controller;

import com.neoris.service.dto.ProductDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "product-queue")
    public void processProductMessage(ProductDto productDto) {
        // Procesar el objeto ProductDto recibido
        System.out.println("Received product: " + productDto.getName());
    }
}
