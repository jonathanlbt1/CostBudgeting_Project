package org.example.costbudgeting.services;

import org.example.costbudgeting.entities.Client;

import java.util.List;

public interface ClientService {

    Client createNewClient(Client client);

    void deleteClient(Long id);

    Client updateClient(Long id, Client client);

    List<Client> listAllClients();

    Client getClient(Long id);
}
