package com.example.carwash.publishers;

import com.example.carwash.dtos.Client;
import com.example.carwash.dtos.Treatment;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ClientPublisher {
    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.queue}")
    private String queue;

    public ClientPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public Client publishClient(Client client) {
        double total = client.getTreatments()
                .stream()
                .mapToDouble(Treatment::getPrice)
                .sum();
        client.setTotal(total);

        int totalDuration = client.getTreatments()
                .stream()
                .mapToInt(Treatment::getDuration)
                .sum();

        LocalDateTime estimatedEndTime = client.getAppointmentDate().plusMinutes(totalDuration);
        client.setEstimatedEndTime(estimatedEndTime);

        rabbitTemplate.convertAndSend(queue, client);
        return client;
    }
}

