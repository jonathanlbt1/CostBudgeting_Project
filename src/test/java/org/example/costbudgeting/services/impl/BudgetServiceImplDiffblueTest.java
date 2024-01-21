package org.example.costbudgeting.services.impl;

import org.example.costbudgeting.entities.Address;
import org.example.costbudgeting.entities.Budget;
import org.example.costbudgeting.entities.Client;
import org.example.costbudgeting.enums.BrazilianState;
import org.example.costbudgeting.enums.Manufacturer;
import org.example.costbudgeting.enums.ProductType;
import org.example.costbudgeting.repositories.BudgetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {BudgetServiceImpl.class})
@ExtendWith(SpringExtension.class)
class BudgetServiceImplDiffblueTest {
    @MockBean
    private BudgetRepository budgetRepository;

    @Autowired
    private BudgetServiceImpl budgetServiceImpl;

    /**
     * Method under test: {@link BudgetServiceImpl#createNewBudget(Budget)}
     */
    @Test
    void testCreateNewBudget() {
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

        Budget budget = new Budget();
        budget.setBatchSize(3);
        budget.setBrazilianState(BrazilianState.MG);
        budget.setCarModel("Car Model");
        budget.setClient(client);
        budget.setComponents(new HashMap<>());
        budget.setEditalNumber("42");
        budget.setId(1L);
        budget.setManufacturerer(Manufacturer.VOLKSWAGEN);
        budget.setProductType(ProductType.POLICE_CAR);
        budget.setResponsibleEmployee("Responsible Employee");
        budget.setUnitGrossOrder(1);
        budget.setUnitGrossPercentage(1);
        budget.setUnitNetOrder(1);
        budget.setUnitNetPercentage(1);
        when(budgetRepository.save(Mockito.<Budget>any())).thenReturn(budget);

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

        Budget budget2 = new Budget();
        budget2.setBatchSize(3);
        budget2.setBrazilianState(BrazilianState.MG);
        budget2.setCarModel("Car Model");
        budget2.setClient(client2);
        budget2.setComponents(new HashMap<>());
        budget2.setEditalNumber("42");
        budget2.setId(1L);
        budget2.setManufacturerer(Manufacturer.VOLKSWAGEN);
        budget2.setProductType(ProductType.POLICE_CAR);
        budget2.setResponsibleEmployee("Responsible Employee");
        budget2.setUnitGrossOrder(1);
        budget2.setUnitGrossPercentage(1);
        budget2.setUnitNetOrder(1);
        budget2.setUnitNetPercentage(1);

        // Act
        Budget actualCreateNewBudgetResult = budgetServiceImpl.createNewBudget(budget2);

        // Assert
        verify(budgetRepository).save(Mockito.<Budget>any());
        assertSame(budget, actualCreateNewBudgetResult);
    }

    /**
     * Method under test: {@link BudgetServiceImpl#deleteBudget(Long)}
     */
    @Test
    void testDeleteBudget() {
        // Arrange
        doNothing().when(budgetRepository).deleteById(Mockito.<Long>any());

        // Act
        budgetServiceImpl.deleteBudget(1L);

        // Assert that nothing has changed
        verify(budgetRepository).deleteById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link BudgetServiceImpl#updateBudget(Long, Budget)}
     */
    @Test
    void testUpdateBudget() {
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

        Budget budget = new Budget();
        budget.setBatchSize(3);
        budget.setBrazilianState(BrazilianState.MG);
        budget.setCarModel("Car Model");
        budget.setClient(client);
        budget.setComponents(new HashMap<>());
        budget.setEditalNumber("42");
        budget.setId(1L);
        budget.setManufacturerer(Manufacturer.VOLKSWAGEN);
        budget.setProductType(ProductType.POLICE_CAR);
        budget.setResponsibleEmployee("Responsible Employee");
        budget.setUnitGrossOrder(1);
        budget.setUnitGrossPercentage(1);
        budget.setUnitNetOrder(1);
        budget.setUnitNetPercentage(1);
        Optional<Budget> ofResult = Optional.of(budget);

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

        Budget budget2 = new Budget();
        budget2.setBatchSize(3);
        budget2.setBrazilianState(BrazilianState.MG);
        budget2.setCarModel("Car Model");
        budget2.setClient(client2);
        budget2.setComponents(new HashMap<>());
        budget2.setEditalNumber("42");
        budget2.setId(1L);
        budget2.setManufacturerer(Manufacturer.VOLKSWAGEN);
        budget2.setProductType(ProductType.POLICE_CAR);
        budget2.setResponsibleEmployee("Responsible Employee");
        budget2.setUnitGrossOrder(1);
        budget2.setUnitGrossPercentage(1);
        budget2.setUnitNetOrder(1);
        budget2.setUnitNetPercentage(1);
        when(budgetRepository.save(Mockito.<Budget>any())).thenReturn(budget2);
        when(budgetRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

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

        Budget budget3 = new Budget();
        budget3.setBatchSize(3);
        budget3.setBrazilianState(BrazilianState.MG);
        budget3.setCarModel("Car Model");
        budget3.setClient(client3);
        budget3.setComponents(new HashMap<>());
        budget3.setEditalNumber("42");
        budget3.setId(1L);
        budget3.setManufacturerer(Manufacturer.VOLKSWAGEN);
        budget3.setProductType(ProductType.POLICE_CAR);
        budget3.setResponsibleEmployee("Responsible Employee");
        budget3.setUnitGrossOrder(1);
        budget3.setUnitGrossPercentage(1);
        budget3.setUnitNetOrder(1);
        budget3.setUnitNetPercentage(1);

        // Act
        Budget actualUpdateBudgetResult = budgetServiceImpl.updateBudget(1L, budget3);

        // Assert
        verify(budgetRepository).save(Mockito.<Budget>any());
        verify(budgetRepository).findById(Mockito.<Long>any());
        assertSame(budget2, actualUpdateBudgetResult);
    }

    /**
     * Method under test: {@link BudgetServiceImpl#getBudget(Long)}
     */
    @Test
    void testGetBudget() {
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

        Budget budget = new Budget();
        budget.setBatchSize(3);
        budget.setBrazilianState(BrazilianState.MG);
        budget.setCarModel("Car Model");
        budget.setClient(client);
        budget.setComponents(new HashMap<>());
        budget.setEditalNumber("42");
        budget.setId(1L);
        budget.setManufacturerer(Manufacturer.VOLKSWAGEN);
        budget.setProductType(ProductType.POLICE_CAR);
        budget.setResponsibleEmployee("Responsible Employee");
        budget.setUnitGrossOrder(1);
        budget.setUnitGrossPercentage(1);
        budget.setUnitNetOrder(1);
        budget.setUnitNetPercentage(1);
        Optional<Budget> ofResult = Optional.of(budget);
        when(budgetRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act
        Budget actualBudget = budgetServiceImpl.getBudget(1L);

        // Assert
        verify(budgetRepository).findById(Mockito.<Long>any());
        assertSame(budget, actualBudget);
    }
}
