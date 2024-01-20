package org.example.costbudgeting.controllers;

import org.example.costbudgeting.entities.Client;
import org.example.costbudgeting.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/clients")
    public HttpEntity<Client> createNewClient(@RequestBody Client client) {
        return new ResponseEntity<>(clientService.createNewClient(client), HttpStatus.CREATED);
    }
}
