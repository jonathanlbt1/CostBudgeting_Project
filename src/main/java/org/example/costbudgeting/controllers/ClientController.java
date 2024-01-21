package org.example.costbudgeting.controllers;

import org.example.costbudgeting.entities.Client;
import org.example.costbudgeting.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("/clients/{id}")
    public HttpEntity<Client> deleteClient(Long id) {
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/clients/{id}")
    public HttpEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
        return new ResponseEntity<>(clientService.updateClient(id, client), HttpStatus.OK);
    }

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> listAllClients() {
        return new ResponseEntity<>(clientService.listAllClients(), HttpStatus.OK);
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Long id) {
        return new ResponseEntity<>(clientService.getClient(id), HttpStatus.OK);
    }

}
