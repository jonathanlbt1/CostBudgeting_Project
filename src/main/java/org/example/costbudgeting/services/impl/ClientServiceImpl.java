package org.example.costbudgeting.services.impl;

import org.example.costbudgeting.entities.Client;
import org.example.costbudgeting.repositories.ClientRepository;
import org.example.costbudgeting.services.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Client createNewClient(Client client) {
        return repository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Client updateClient(Long id, Client client) {
        Client clientToUpdate = repository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        clientToUpdate.setName(client.getName());
        clientToUpdate.setEmail(client.getEmail());
        clientToUpdate.setPhone(client.getPhone());
        clientToUpdate.setAddress(client.getAddress());
        return repository.save(clientToUpdate);
    }

    @Override
    public List<Client> listAllClients() {
        return (List<Client>) repository.findAll();
    }

    @Override
    public Client getClient(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
    }
}
