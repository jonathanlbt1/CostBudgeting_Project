package org.example.costbudgeting.services;

import org.example.costbudgeting.entities.Client;
import org.example.costbudgeting.repositories.ClientRepository;
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

    }

    @Override
    public Client updateClient(Long id, Client client) {
        return null;
    }

    @Override
    public List<Client> listAllClients() {
        return null;
    }

    @Override
    public Client getClient(Long id) {
        return null;
    }
}
