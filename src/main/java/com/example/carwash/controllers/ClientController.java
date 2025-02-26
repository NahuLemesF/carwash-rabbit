package com.example.carwash.controllers;

import com.example.carwash.dtos.Client;
import com.example.carwash.publishers.ClientPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final ClientPublisher clientPublisher;

    public ClientController(ClientPublisher clientPublisher) {
        this.clientPublisher = clientPublisher;
    }

    @PostMapping
    public Client publishClient(@RequestBody Client client) {
        return clientPublisher.publishClient(client);
    }
}
