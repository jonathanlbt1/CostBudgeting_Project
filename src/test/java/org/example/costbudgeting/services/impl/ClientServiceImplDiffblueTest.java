package org.example.costbudgeting.services.impl;

import org.example.costbudgeting.entities.Address;
import org.example.costbudgeting.entities.Client;
import org.example.costbudgeting.enums.BrazilianState;
import org.example.costbudgeting.repositories.ClientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {ClientServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ClientServiceImplDiffblueTest {
    @MockBean
    private ClientRepository clientRepository;

    @Autowired
    private ClientServiceImpl clientServiceImpl;

    /**
     * Method under test: {@link ClientServiceImpl#createNewClient(Client)}
     */
    @Test
    void testCreateNewClient() {
        // Arrange
        Address address = new Address();
        address.setCity("Oxford");
        address.setComplement("Complement");
        address.setId(1L);
        address.setNeighborhood("Neighborhood");
        address.setNumber("42");
        address.setState(BrazilianState.MG);
        address.setStreet("Street");
        address.setZipCode("21654");

        Client client = new Client();
        client.setAddress(address);
        client.setEmail("jane.doe@example.org");
        client.setId(1L);
        client.setName("Name");
        client.setPhone("6625550144");
        when(clientRepository.save(Mockito.any())).thenReturn(client);

        Address address2 = new Address();
        address2.setCity("Oxford");
        address2.setComplement("Complement");
        address2.setId(1L);
        address2.setNeighborhood("Neighborhood");
        address2.setNumber("42");
        address2.setState(BrazilianState.MG);
        address2.setStreet("Street");
        address2.setZipCode("21654");

        Client client2 = new Client();
        client2.setAddress(address2);
        client2.setEmail("jane.doe@example.org");
        client2.setId(1L);
        client2.setName("Name");
        client2.setPhone("6625550144");

        // Act
        Client actualCreateNewClientResult = clientServiceImpl.createNewClient(client2);

        // Assert
        verify(clientRepository).save(Mockito.<Client>any());
        assertSame(client, actualCreateNewClientResult);
    }

    /**
     * Method under test: {@link ClientServiceImpl#createNewClient(Client)}
     */
    @Test
    void testCreateNewClient2() {
        // Arrange
        when(clientRepository.save(Mockito.<Client>any())).thenThrow(new RuntimeException("foo"));

        Address address = new Address();
        address.setCity("Oxford");
        address.setComplement("Complement");
        address.setId(1L);
        address.setNeighborhood("Neighborhood");
        address.setNumber("42");
        address.setState(BrazilianState.MG);
        address.setStreet("Street");
        address.setZipCode("21654");

        Client client = new Client();
        client.setAddress(address);
        client.setEmail("jane.doe@example.org");
        client.setId(1L);
        client.setName("Name");
        client.setPhone("6625550144");

        // Act and Assert
        assertThrows(RuntimeException.class, () -> clientServiceImpl.createNewClient(client));
        verify(clientRepository).save(Mockito.<Client>any());
    }

    /**
     * Method under test: {@link ClientServiceImpl#deleteClient(Long)}
     */
    @Test
    void testDeleteClient() {
        // Arrange
        doNothing().when(clientRepository).deleteById(Mockito.<Long>any());

        // Act
        clientServiceImpl.deleteClient(1L);

        // Assert that nothing has changed
        verify(clientRepository).deleteById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link ClientServiceImpl#deleteClient(Long)}
     */
    @Test
    void testDeleteClient2() {
        // Arrange
        doThrow(new RuntimeException("foo")).when(clientRepository).deleteById(Mockito.<Long>any());

        // Act and Assert
        assertThrows(RuntimeException.class, () -> clientServiceImpl.deleteClient(1L));
        verify(clientRepository).deleteById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link ClientServiceImpl#updateClient(Long, Client)}
     */
    @Test
    void testUpdateClient() {
        // Arrange
        Address address = new Address();
        address.setCity("Oxford");
        address.setComplement("Complement");
        address.setId(1L);
        address.setNeighborhood("Neighborhood");
        address.setNumber("42");
        address.setState(BrazilianState.MG);
        address.setStreet("Street");
        address.setZipCode("21654");

        Client client = new Client();
        client.setAddress(address);
        client.setEmail("jane.doe@example.org");
        client.setId(1L);
        client.setName("Name");
        client.setPhone("6625550144");
        Optional<Client> ofResult = Optional.of(client);

        Address address2 = new Address();
        address2.setCity("Oxford");
        address2.setComplement("Complement");
        address2.setId(1L);
        address2.setNeighborhood("Neighborhood");
        address2.setNumber("42");
        address2.setState(BrazilianState.MG);
        address2.setStreet("Street");
        address2.setZipCode("21654");

        Client client2 = new Client();
        client2.setAddress(address2);
        client2.setEmail("jane.doe@example.org");
        client2.setId(1L);
        client2.setName("Name");
        client2.setPhone("6625550144");
        when(clientRepository.save(Mockito.<Client>any())).thenReturn(client2);
        when(clientRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        Address address3 = new Address();
        address3.setCity("Oxford");
        address3.setComplement("Complement");
        address3.setId(1L);
        address3.setNeighborhood("Neighborhood");
        address3.setNumber("42");
        address3.setState(BrazilianState.MG);
        address3.setStreet("Street");
        address3.setZipCode("21654");

        Client client3 = new Client();
        client3.setAddress(address3);
        client3.setEmail("jane.doe@example.org");
        client3.setId(1L);
        client3.setName("Name");
        client3.setPhone("6625550144");

        // Act
        Client actualUpdateClientResult = clientServiceImpl.updateClient(1L, client3);

        // Assert
        verify(clientRepository).findById(Mockito.<Long>any());
        verify(clientRepository).save(Mockito.<Client>any());
        assertSame(client2, actualUpdateClientResult);
    }

    /**
     * Method under test: {@link ClientServiceImpl#updateClient(Long, Client)}
     */
    @Test
    void testUpdateClient2() {
        // Arrange
        Address address = new Address();
        address.setCity("Oxford");
        address.setComplement("Complement");
        address.setId(1L);
        address.setNeighborhood("Neighborhood");
        address.setNumber("42");
        address.setState(BrazilianState.MG);
        address.setStreet("Street");
        address.setZipCode("21654");

        Client client = new Client();
        client.setAddress(address);
        client.setEmail("jane.doe@example.org");
        client.setId(1L);
        client.setName("Name");
        client.setPhone("6625550144");
        Optional<Client> ofResult = Optional.of(client);
        when(clientRepository.save(Mockito.<Client>any())).thenThrow(new RuntimeException("foo"));
        when(clientRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        Address address2 = new Address();
        address2.setCity("Oxford");
        address2.setComplement("Complement");
        address2.setId(1L);
        address2.setNeighborhood("Neighborhood");
        address2.setNumber("42");
        address2.setState(BrazilianState.MG);
        address2.setStreet("Street");
        address2.setZipCode("21654");

        Client client2 = new Client();
        client2.setAddress(address2);
        client2.setEmail("jane.doe@example.org");
        client2.setId(1L);
        client2.setName("Name");
        client2.setPhone("6625550144");

        // Act and Assert
        assertThrows(RuntimeException.class, () -> clientServiceImpl.updateClient(1L, client2));
        verify(clientRepository).findById(Mockito.<Long>any());
        verify(clientRepository).save(Mockito.<Client>any());
    }

    /**
     * Method under test: {@link ClientServiceImpl#updateClient(Long, Client)}
     */
    @Test
    void testUpdateClient3() {
        // Arrange
        Optional<Client> emptyResult = Optional.empty();
        when(clientRepository.findById(Mockito.<Long>any())).thenReturn(emptyResult);

        Address address = new Address();
        address.setCity("Oxford");
        address.setComplement("Complement");
        address.setId(1L);
        address.setNeighborhood("Neighborhood");
        address.setNumber("42");
        address.setState(BrazilianState.MG);
        address.setStreet("Street");
        address.setZipCode("21654");

        Client client = new Client();
        client.setAddress(address);
        client.setEmail("jane.doe@example.org");
        client.setId(1L);
        client.setName("Name");
        client.setPhone("6625550144");

        // Act and Assert
        assertThrows(RuntimeException.class, () -> clientServiceImpl.updateClient(1L, client));
        verify(clientRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link ClientServiceImpl#listAllClients()}
     */
    @Test
    void testListAllClients() {
        // Arrange
        ArrayList<Client> clientList = new ArrayList<>();
        when(clientRepository.findAll()).thenReturn(clientList);

        // Act
        List<Client> actualListAllClientsResult = clientServiceImpl.listAllClients();

        // Assert
        verify(clientRepository).findAll();
        assertTrue(actualListAllClientsResult.isEmpty());
        assertSame(clientList, actualListAllClientsResult);
    }

    /**
     * Method under test: {@link ClientServiceImpl#listAllClients()}
     */
    @Test
    void testListAllClients2() {
        // Arrange
        when(clientRepository.findAll()).thenThrow(new RuntimeException("foo"));

        // Act and Assert
        assertThrows(RuntimeException.class, () -> clientServiceImpl.listAllClients());
        verify(clientRepository).findAll();
    }

    /**
     * Method under test: {@link ClientServiceImpl#getClient(Long)}
     */
    @Test
    void testGetClient() {
        // Arrange
        Address address = new Address();
        address.setCity("Oxford");
        address.setComplement("Complement");
        address.setId(1L);
        address.setNeighborhood("Neighborhood");
        address.setNumber("42");
        address.setState(BrazilianState.MG);
        address.setStreet("Street");
        address.setZipCode("21654");

        Client client = new Client();
        client.setAddress(address);
        client.setEmail("jane.doe@example.org");
        client.setId(1L);
        client.setName("Name");
        client.setPhone("6625550144");
        Optional<Client> ofResult = Optional.of(client);
        when(clientRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act
        Client actualClient = clientServiceImpl.getClient(1L);

        // Assert
        verify(clientRepository).findById(Mockito.<Long>any());
        assertSame(client, actualClient);
    }

    /**
     * Method under test: {@link ClientServiceImpl#getClient(Long)}
     */
    @Test
    void testGetClient2() {
        // Arrange
        Optional<Client> emptyResult = Optional.empty();
        when(clientRepository.findById(Mockito.<Long>any())).thenReturn(emptyResult);

        // Act and Assert
        assertThrows(RuntimeException.class, () -> clientServiceImpl.getClient(1L));
        verify(clientRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link ClientServiceImpl#getClient(Long)}
     */
    @Test
    void testGetClient3() {
        // Arrange
        when(clientRepository.findById(Mockito.<Long>any())).thenThrow(new RuntimeException("Client not found"));

        // Act and Assert
        assertThrows(RuntimeException.class, () -> clientServiceImpl.getClient(1L));
        verify(clientRepository).findById(Mockito.<Long>any());
    }
}
