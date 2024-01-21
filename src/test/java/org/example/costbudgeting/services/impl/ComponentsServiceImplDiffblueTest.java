package org.example.costbudgeting.services.impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Optional;

import org.example.costbudgeting.entities.Address;
import org.example.costbudgeting.entities.Budget;
import org.example.costbudgeting.entities.Client;
import org.example.costbudgeting.entities.costsbreakdown.Components;
import org.example.costbudgeting.entities.costsbreakdown.LaborCost;
import org.example.costbudgeting.entities.costsbreakdown.RawMaterial;
import org.example.costbudgeting.entities.costsbreakdown.enums.HourTax;
import org.example.costbudgeting.entities.taxes.Taxes;
import org.example.costbudgeting.entities.taxes.enums.ICMS;
import org.example.costbudgeting.entities.taxes.enums.IPI;
import org.example.costbudgeting.entities.taxes.enums.PIS_COFINS;
import org.example.costbudgeting.enums.BrazilianState;
import org.example.costbudgeting.enums.Manufacturer;
import org.example.costbudgeting.enums.ProductType;
import org.example.costbudgeting.repositories.ComponentsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ComponentsServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ComponentsServiceImplDiffblueTest {
    @MockBean
    private ComponentsRepository componentsRepository;

    @Autowired
    private ComponentsServiceImpl componentsServiceImpl;

    /**
     * Method under test:
     * {@link ComponentsServiceImpl#createNewComponents(Components)}
     */
    @Test
    void testCreateNewComponents() {
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

        Client client2 = new Client();
        client2.setAddress(new Address());
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

        Components components = new Components();
        components.setBudget(new Budget());
        components.setComponentName("Component Name");
        components.setId(1L);
        components.setLaborCost(new LaborCost());
        components.setRawMaterial(new RawMaterial());

        LaborCost laborCost = new LaborCost();
        laborCost.setBudgetTime(1L);
        laborCost.setComponents(components);
        laborCost.setHourTax(HourTax.HOUR_TAX_ISENTO);
        laborCost.setId(1L);
        laborCost.setLaborCostName("Labor Cost Name");

        Components components2 = new Components();
        components2.setBudget(new Budget());
        components2.setComponentName("Component Name");
        components2.setId(1L);
        components2.setLaborCost(new LaborCost());
        components2.setRawMaterial(new RawMaterial());

        Taxes taxes = new Taxes();
        taxes.setIcms(ICMS.ICMS_ISENTO);
        taxes.setId(1L);
        taxes.setIpi(IPI.IPI_ISENTO);
        taxes.setPis_cofins(PIS_COFINS.PIS_COFINS_ISENTO);

        RawMaterial rawMaterial = new RawMaterial();
        rawMaterial.setComponents(components2);
        rawMaterial.setId(1L);
        rawMaterial.setPrice(1L);
        rawMaterial.setQuantity(1);
        rawMaterial.setRawMaterialName("Raw Material Name");
        rawMaterial.setSourceChecked("Source Checked");
        rawMaterial.setTaxes(taxes);

        Components components3 = new Components();
        components3.setBudget(budget2);
        components3.setComponentName("Component Name");
        components3.setId(1L);
        components3.setLaborCost(laborCost);
        components3.setRawMaterial(rawMaterial);

        LaborCost laborCost2 = new LaborCost();
        laborCost2.setBudgetTime(1L);
        laborCost2.setComponents(components3);
        laborCost2.setHourTax(HourTax.HOUR_TAX_ISENTO);
        laborCost2.setId(1L);
        laborCost2.setLaborCostName("Labor Cost Name");

        Client client3 = new Client();
        client3.setAddress(new Address());
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

        Components components4 = new Components();
        components4.setBudget(new Budget());
        components4.setComponentName("Component Name");
        components4.setId(1L);
        components4.setLaborCost(new LaborCost());
        components4.setRawMaterial(new RawMaterial());

        LaborCost laborCost3 = new LaborCost();
        laborCost3.setBudgetTime(1L);
        laborCost3.setComponents(components4);
        laborCost3.setHourTax(HourTax.HOUR_TAX_ISENTO);
        laborCost3.setId(1L);
        laborCost3.setLaborCostName("Labor Cost Name");

        Components components5 = new Components();
        components5.setBudget(new Budget());
        components5.setComponentName("Component Name");
        components5.setId(1L);
        components5.setLaborCost(new LaborCost());
        components5.setRawMaterial(new RawMaterial());

        Taxes taxes2 = new Taxes();
        taxes2.setIcms(ICMS.ICMS_ISENTO);
        taxes2.setId(1L);
        taxes2.setIpi(IPI.IPI_ISENTO);
        taxes2.setPis_cofins(PIS_COFINS.PIS_COFINS_ISENTO);

        RawMaterial rawMaterial2 = new RawMaterial();
        rawMaterial2.setComponents(components5);
        rawMaterial2.setId(1L);
        rawMaterial2.setPrice(1L);
        rawMaterial2.setQuantity(1);
        rawMaterial2.setRawMaterialName("Raw Material Name");
        rawMaterial2.setSourceChecked("Source Checked");
        rawMaterial2.setTaxes(taxes2);

        Components components6 = new Components();
        components6.setBudget(budget3);
        components6.setComponentName("Component Name");
        components6.setId(1L);
        components6.setLaborCost(laborCost3);
        components6.setRawMaterial(rawMaterial2);

        Taxes taxes3 = new Taxes();
        taxes3.setIcms(ICMS.ICMS_ISENTO);
        taxes3.setId(1L);
        taxes3.setIpi(IPI.IPI_ISENTO);
        taxes3.setPis_cofins(PIS_COFINS.PIS_COFINS_ISENTO);

        RawMaterial rawMaterial3 = new RawMaterial();
        rawMaterial3.setComponents(components6);
        rawMaterial3.setId(1L);
        rawMaterial3.setPrice(1L);
        rawMaterial3.setQuantity(1);
        rawMaterial3.setRawMaterialName("Raw Material Name");
        rawMaterial3.setSourceChecked("Source Checked");
        rawMaterial3.setTaxes(taxes3);

        Components components7 = new Components();
        components7.setBudget(budget);
        components7.setComponentName("Component Name");
        components7.setId(1L);
        components7.setLaborCost(laborCost2);
        components7.setRawMaterial(rawMaterial3);
        when(componentsRepository.save(Mockito.<Components>any())).thenReturn(components7);

        Address address2 = new Address();
        address2.setCity("Oxford");
        address2.setComplement("Complement");
        address2.setId(1L);
        address2.setNeighborhood("Neighborhood");
        address2.setNumber("42");
        address2.setState(BrazilianState.MG);
        address2.setStreet("Street");
        address2.setZipCode("21654");

        Client client4 = new Client();
        client4.setAddress(address2);
        client4.setEmail("jane.doe@example.org");
        client4.setId(1L);
        client4.setName("Name");
        client4.setPhone("6625550144");

        Budget budget4 = new Budget();
        budget4.setBatchSize(3);
        budget4.setBrazilianState(BrazilianState.MG);
        budget4.setCarModel("Car Model");
        budget4.setClient(client4);
        budget4.setComponents(new HashMap<>());
        budget4.setEditalNumber("42");
        budget4.setId(1L);
        budget4.setManufacturerer(Manufacturer.VOLKSWAGEN);
        budget4.setProductType(ProductType.POLICE_CAR);
        budget4.setResponsibleEmployee("Responsible Employee");
        budget4.setUnitGrossOrder(1);
        budget4.setUnitGrossPercentage(1);
        budget4.setUnitNetOrder(1);
        budget4.setUnitNetPercentage(1);

        Budget budget5 = new Budget();
        budget5.setBatchSize(3);
        budget5.setBrazilianState(BrazilianState.MG);
        budget5.setCarModel("Car Model");
        budget5.setClient(new Client());
        budget5.setComponents(new HashMap<>());
        budget5.setEditalNumber("42");
        budget5.setId(1L);
        budget5.setManufacturerer(Manufacturer.VOLKSWAGEN);
        budget5.setProductType(ProductType.POLICE_CAR);
        budget5.setResponsibleEmployee("Responsible Employee");
        budget5.setUnitGrossOrder(1);
        budget5.setUnitGrossPercentage(1);
        budget5.setUnitNetOrder(1);
        budget5.setUnitNetPercentage(1);

        LaborCost laborCost4 = new LaborCost();
        laborCost4.setBudgetTime(1L);
        laborCost4.setComponents(new Components());
        laborCost4.setHourTax(HourTax.HOUR_TAX_ISENTO);
        laborCost4.setId(1L);
        laborCost4.setLaborCostName("Labor Cost Name");

        RawMaterial rawMaterial4 = new RawMaterial();
        rawMaterial4.setComponents(new Components());
        rawMaterial4.setId(1L);
        rawMaterial4.setPrice(1L);
        rawMaterial4.setQuantity(1);
        rawMaterial4.setRawMaterialName("Raw Material Name");
        rawMaterial4.setSourceChecked("Source Checked");
        rawMaterial4.setTaxes(new Taxes());

        Components components8 = new Components();
        components8.setBudget(budget5);
        components8.setComponentName("Component Name");
        components8.setId(1L);
        components8.setLaborCost(laborCost4);
        components8.setRawMaterial(rawMaterial4);

        LaborCost laborCost5 = new LaborCost();
        laborCost5.setBudgetTime(1L);
        laborCost5.setComponents(components8);
        laborCost5.setHourTax(HourTax.HOUR_TAX_ISENTO);
        laborCost5.setId(1L);
        laborCost5.setLaborCostName("Labor Cost Name");

        Budget budget6 = new Budget();
        budget6.setBatchSize(3);
        budget6.setBrazilianState(BrazilianState.MG);
        budget6.setCarModel("Car Model");
        budget6.setClient(new Client());
        budget6.setComponents(new HashMap<>());
        budget6.setEditalNumber("42");
        budget6.setId(1L);
        budget6.setManufacturerer(Manufacturer.VOLKSWAGEN);
        budget6.setProductType(ProductType.POLICE_CAR);
        budget6.setResponsibleEmployee("Responsible Employee");
        budget6.setUnitGrossOrder(1);
        budget6.setUnitGrossPercentage(1);
        budget6.setUnitNetOrder(1);
        budget6.setUnitNetPercentage(1);

        LaborCost laborCost6 = new LaborCost();
        laborCost6.setBudgetTime(1L);
        laborCost6.setComponents(new Components());
        laborCost6.setHourTax(HourTax.HOUR_TAX_ISENTO);
        laborCost6.setId(1L);
        laborCost6.setLaborCostName("Labor Cost Name");

        RawMaterial rawMaterial5 = new RawMaterial();
        rawMaterial5.setComponents(new Components());
        rawMaterial5.setId(1L);
        rawMaterial5.setPrice(1L);
        rawMaterial5.setQuantity(1);
        rawMaterial5.setRawMaterialName("Raw Material Name");
        rawMaterial5.setSourceChecked("Source Checked");
        rawMaterial5.setTaxes(new Taxes());

        Components components9 = new Components();
        components9.setBudget(budget6);
        components9.setComponentName("Component Name");
        components9.setId(1L);
        components9.setLaborCost(laborCost6);
        components9.setRawMaterial(rawMaterial5);

        Taxes taxes4 = new Taxes();
        taxes4.setIcms(ICMS.ICMS_ISENTO);
        taxes4.setId(1L);
        taxes4.setIpi(IPI.IPI_ISENTO);
        taxes4.setPis_cofins(PIS_COFINS.PIS_COFINS_ISENTO);

        RawMaterial rawMaterial6 = new RawMaterial();
        rawMaterial6.setComponents(components9);
        rawMaterial6.setId(1L);
        rawMaterial6.setPrice(1L);
        rawMaterial6.setQuantity(1);
        rawMaterial6.setRawMaterialName("Raw Material Name");
        rawMaterial6.setSourceChecked("Source Checked");
        rawMaterial6.setTaxes(taxes4);

        Components components10 = new Components();
        components10.setBudget(budget4);
        components10.setComponentName("Component Name");
        components10.setId(1L);
        components10.setLaborCost(laborCost5);
        components10.setRawMaterial(rawMaterial6);

        // Act
        Components actualCreateNewComponentsResult = componentsServiceImpl.createNewComponents(components10);

        // Assert
        verify(componentsRepository).save(Mockito.<Components>any());
        assertSame(components7, actualCreateNewComponentsResult);
    }

    /**
     * Method under test: {@link ComponentsServiceImpl#deleteComponents(Long)}
     */
    @Test
    void testDeleteComponents() {
        // Arrange
        doNothing().when(componentsRepository).deleteById(Mockito.<Long>any());

        // Act
        componentsServiceImpl.deleteComponents(1L);

        // Assert that nothing has changed
        verify(componentsRepository).deleteById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link ComponentsServiceImpl#deleteComponents(Long)}
     */
    @Test
    void testDeleteComponents2() {
        // Arrange
        doThrow(new RuntimeException("foo")).when(componentsRepository).deleteById(Mockito.<Long>any());

        // Act and Assert
        assertThrows(RuntimeException.class, () -> componentsServiceImpl.deleteComponents(1L));
        verify(componentsRepository).deleteById(Mockito.<Long>any());
    }

    /**
     * Method under test:
     * {@link ComponentsServiceImpl#updateComponents(Long, Components)}
     */
    @Test
    void testUpdateComponents() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.RuntimeException: Components not found
        //       at org.example.costbudgeting.services.impl.ComponentsServiceImpl.lambda$updateComponents$0(ComponentsServiceImpl.java:32)
        //       at java.base/java.util.Optional.orElseThrow(Optional.java:403)
        //       at org.example.costbudgeting.services.impl.ComponentsServiceImpl.updateComponents(ComponentsServiceImpl.java:31)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        Components components = mock(Components.class);
        doNothing().when(components).setComponentName(Mockito.<String>any());
        doNothing().when(components).setLaborCost(Mockito.<LaborCost>any());
        doNothing().when(components).setRawMaterial(Mockito.<RawMaterial>any());
        Optional<Components> ofResult = Optional.of(components);

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

        Client client2 = new Client();
        client2.setAddress(new Address());
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

        Components components2 = new Components();
        components2.setBudget(new Budget());
        components2.setComponentName("Component Name");
        components2.setId(1L);
        components2.setLaborCost(new LaborCost());
        components2.setRawMaterial(new RawMaterial());

        LaborCost laborCost = new LaborCost();
        laborCost.setBudgetTime(1L);
        laborCost.setComponents(components2);
        laborCost.setHourTax(HourTax.HOUR_TAX_ISENTO);
        laborCost.setId(1L);
        laborCost.setLaborCostName("Labor Cost Name");

        Components components3 = new Components();
        components3.setBudget(new Budget());
        components3.setComponentName("Component Name");
        components3.setId(1L);
        components3.setLaborCost(new LaborCost());
        components3.setRawMaterial(new RawMaterial());

        Taxes taxes = new Taxes();
        taxes.setIcms(ICMS.ICMS_ISENTO);
        taxes.setId(1L);
        taxes.setIpi(IPI.IPI_ISENTO);
        taxes.setPis_cofins(PIS_COFINS.PIS_COFINS_ISENTO);

        RawMaterial rawMaterial = new RawMaterial();
        rawMaterial.setComponents(components3);
        rawMaterial.setId(1L);
        rawMaterial.setPrice(1L);
        rawMaterial.setQuantity(1);
        rawMaterial.setRawMaterialName("Raw Material Name");
        rawMaterial.setSourceChecked("Source Checked");
        rawMaterial.setTaxes(taxes);

        Components components4 = new Components();
        components4.setBudget(budget2);
        components4.setComponentName("Component Name");
        components4.setId(1L);
        components4.setLaborCost(laborCost);
        components4.setRawMaterial(rawMaterial);

        LaborCost laborCost2 = new LaborCost();
        laborCost2.setBudgetTime(1L);
        laborCost2.setComponents(components4);
        laborCost2.setHourTax(HourTax.HOUR_TAX_ISENTO);
        laborCost2.setId(1L);
        laborCost2.setLaborCostName("Labor Cost Name");

        Client client3 = new Client();
        client3.setAddress(new Address());
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

        Components components5 = new Components();
        components5.setBudget(new Budget());
        components5.setComponentName("Component Name");
        components5.setId(1L);
        components5.setLaborCost(new LaborCost());
        components5.setRawMaterial(new RawMaterial());

        LaborCost laborCost3 = new LaborCost();
        laborCost3.setBudgetTime(1L);
        laborCost3.setComponents(components5);
        laborCost3.setHourTax(HourTax.HOUR_TAX_ISENTO);
        laborCost3.setId(1L);
        laborCost3.setLaborCostName("Labor Cost Name");

        Components components6 = new Components();
        components6.setBudget(new Budget());
        components6.setComponentName("Component Name");
        components6.setId(1L);
        components6.setLaborCost(new LaborCost());
        components6.setRawMaterial(new RawMaterial());

        Taxes taxes2 = new Taxes();
        taxes2.setIcms(ICMS.ICMS_ISENTO);
        taxes2.setId(1L);
        taxes2.setIpi(IPI.IPI_ISENTO);
        taxes2.setPis_cofins(PIS_COFINS.PIS_COFINS_ISENTO);

        RawMaterial rawMaterial2 = new RawMaterial();
        rawMaterial2.setComponents(components6);
        rawMaterial2.setId(1L);
        rawMaterial2.setPrice(1L);
        rawMaterial2.setQuantity(1);
        rawMaterial2.setRawMaterialName("Raw Material Name");
        rawMaterial2.setSourceChecked("Source Checked");
        rawMaterial2.setTaxes(taxes2);

        Components components7 = new Components();
        components7.setBudget(budget3);
        components7.setComponentName("Component Name");
        components7.setId(1L);
        components7.setLaborCost(laborCost3);
        components7.setRawMaterial(rawMaterial2);

        Taxes taxes3 = new Taxes();
        taxes3.setIcms(ICMS.ICMS_ISENTO);
        taxes3.setId(1L);
        taxes3.setIpi(IPI.IPI_ISENTO);
        taxes3.setPis_cofins(PIS_COFINS.PIS_COFINS_ISENTO);

        RawMaterial rawMaterial3 = new RawMaterial();
        rawMaterial3.setComponents(components7);
        rawMaterial3.setId(1L);
        rawMaterial3.setPrice(1L);
        rawMaterial3.setQuantity(1);
        rawMaterial3.setRawMaterialName("Raw Material Name");
        rawMaterial3.setSourceChecked("Source Checked");
        rawMaterial3.setTaxes(taxes3);

        Components components8 = new Components();
        components8.setBudget(budget);
        components8.setComponentName("Component Name");
        components8.setId(1L);
        components8.setLaborCost(laborCost2);
        components8.setRawMaterial(rawMaterial3);
        ComponentsRepository repository = mock(ComponentsRepository.class);
        when(repository.save(Mockito.<Components>any())).thenReturn(components8);
        when(repository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        ComponentsServiceImpl componentsServiceImpl = new ComponentsServiceImpl(repository);

        Address address2 = new Address();
        address2.setCity("Oxford");
        address2.setComplement("Complement");
        address2.setId(1L);
        address2.setNeighborhood("Neighborhood");
        address2.setNumber("42");
        address2.setState(BrazilianState.MG);
        address2.setStreet("Street");
        address2.setZipCode("21654");

        Client client4 = new Client();
        client4.setAddress(address2);
        client4.setEmail("jane.doe@example.org");
        client4.setId(1L);
        client4.setName("Name");
        client4.setPhone("6625550144");

        Budget budget4 = new Budget();
        budget4.setBatchSize(3);
        budget4.setBrazilianState(BrazilianState.MG);
        budget4.setCarModel("Car Model");
        budget4.setClient(client4);
        budget4.setComponents(new HashMap<>());
        budget4.setEditalNumber("42");
        budget4.setId(1L);
        budget4.setManufacturerer(Manufacturer.VOLKSWAGEN);
        budget4.setProductType(ProductType.POLICE_CAR);
        budget4.setResponsibleEmployee("Responsible Employee");
        budget4.setUnitGrossOrder(1);
        budget4.setUnitGrossPercentage(1);
        budget4.setUnitNetOrder(1);
        budget4.setUnitNetPercentage(1);

        Budget budget5 = new Budget();
        budget5.setBatchSize(3);
        budget5.setBrazilianState(BrazilianState.MG);
        budget5.setCarModel("Car Model");
        budget5.setClient(new Client());
        budget5.setComponents(new HashMap<>());
        budget5.setEditalNumber("42");
        budget5.setId(1L);
        budget5.setManufacturerer(Manufacturer.VOLKSWAGEN);
        budget5.setProductType(ProductType.POLICE_CAR);
        budget5.setResponsibleEmployee("Responsible Employee");
        budget5.setUnitGrossOrder(1);
        budget5.setUnitGrossPercentage(1);
        budget5.setUnitNetOrder(1);
        budget5.setUnitNetPercentage(1);

        LaborCost laborCost4 = new LaborCost();
        laborCost4.setBudgetTime(1L);
        laborCost4.setComponents(new Components());
        laborCost4.setHourTax(HourTax.HOUR_TAX_ISENTO);
        laborCost4.setId(1L);
        laborCost4.setLaborCostName("Labor Cost Name");

        RawMaterial rawMaterial4 = new RawMaterial();
        rawMaterial4.setComponents(new Components());
        rawMaterial4.setId(1L);
        rawMaterial4.setPrice(1L);
        rawMaterial4.setQuantity(1);
        rawMaterial4.setRawMaterialName("Raw Material Name");
        rawMaterial4.setSourceChecked("Source Checked");
        rawMaterial4.setTaxes(new Taxes());

        Components components9 = new Components();
        components9.setBudget(budget5);
        components9.setComponentName("Component Name");
        components9.setId(1L);
        components9.setLaborCost(laborCost4);
        components9.setRawMaterial(rawMaterial4);

        LaborCost laborCost5 = new LaborCost();
        laborCost5.setBudgetTime(1L);
        laborCost5.setComponents(components9);
        laborCost5.setHourTax(HourTax.HOUR_TAX_ISENTO);
        laborCost5.setId(1L);
        laborCost5.setLaborCostName("Labor Cost Name");

        Budget budget6 = new Budget();
        budget6.setBatchSize(3);
        budget6.setBrazilianState(BrazilianState.MG);
        budget6.setCarModel("Car Model");
        budget6.setClient(new Client());
        budget6.setComponents(new HashMap<>());
        budget6.setEditalNumber("42");
        budget6.setId(1L);
        budget6.setManufacturerer(Manufacturer.VOLKSWAGEN);
        budget6.setProductType(ProductType.POLICE_CAR);
        budget6.setResponsibleEmployee("Responsible Employee");
        budget6.setUnitGrossOrder(1);
        budget6.setUnitGrossPercentage(1);
        budget6.setUnitNetOrder(1);
        budget6.setUnitNetPercentage(1);

        LaborCost laborCost6 = new LaborCost();
        laborCost6.setBudgetTime(1L);
        laborCost6.setComponents(new Components());
        laborCost6.setHourTax(HourTax.HOUR_TAX_ISENTO);
        laborCost6.setId(1L);
        laborCost6.setLaborCostName("Labor Cost Name");

        RawMaterial rawMaterial5 = new RawMaterial();
        rawMaterial5.setComponents(new Components());
        rawMaterial5.setId(1L);
        rawMaterial5.setPrice(1L);
        rawMaterial5.setQuantity(1);
        rawMaterial5.setRawMaterialName("Raw Material Name");
        rawMaterial5.setSourceChecked("Source Checked");
        rawMaterial5.setTaxes(new Taxes());

        Components components10 = new Components();
        components10.setBudget(budget6);
        components10.setComponentName("Component Name");
        components10.setId(1L);
        components10.setLaborCost(laborCost6);
        components10.setRawMaterial(rawMaterial5);

        Taxes taxes4 = new Taxes();
        taxes4.setIcms(ICMS.ICMS_ISENTO);
        taxes4.setId(1L);
        taxes4.setIpi(IPI.IPI_ISENTO);
        taxes4.setPis_cofins(PIS_COFINS.PIS_COFINS_ISENTO);

        RawMaterial rawMaterial6 = new RawMaterial();
        rawMaterial6.setComponents(components10);
        rawMaterial6.setId(1L);
        rawMaterial6.setPrice(1L);
        rawMaterial6.setQuantity(1);
        rawMaterial6.setRawMaterialName("Raw Material Name");
        rawMaterial6.setSourceChecked("Source Checked");
        rawMaterial6.setTaxes(taxes4);

        Components components11 = new Components();
        components11.setBudget(budget4);
        components11.setComponentName("Component Name");
        components11.setId(1L);
        components11.setLaborCost(laborCost5);
        components11.setRawMaterial(rawMaterial6);

        LaborCost laborCost7 = new LaborCost();
        laborCost7.setBudgetTime(1L);
        laborCost7.setComponents(components11);
        laborCost7.setHourTax(HourTax.HOUR_TAX_ISENTO);
        laborCost7.setId(1L);
        laborCost7.setLaborCostName("Labor Cost Name");

        Address address3 = new Address();
        address3.setCity("Oxford");
        address3.setComplement("Complement");
        address3.setId(1L);
        address3.setNeighborhood("Neighborhood");
        address3.setNumber("42");
        address3.setState(BrazilianState.MG);
        address3.setStreet("Street");
        address3.setZipCode("21654");

        Client client5 = new Client();
        client5.setAddress(address3);
        client5.setEmail("jane.doe@example.org");
        client5.setId(1L);
        client5.setName("Name");
        client5.setPhone("6625550144");

        Budget budget7 = new Budget();
        budget7.setBatchSize(3);
        budget7.setBrazilianState(BrazilianState.MG);
        budget7.setCarModel("Car Model");
        budget7.setClient(client5);
        budget7.setComponents(new HashMap<>());
        budget7.setEditalNumber("42");
        budget7.setId(1L);
        budget7.setManufacturerer(Manufacturer.VOLKSWAGEN);
        budget7.setProductType(ProductType.POLICE_CAR);
        budget7.setResponsibleEmployee("Responsible Employee");
        budget7.setUnitGrossOrder(1);
        budget7.setUnitGrossPercentage(1);
        budget7.setUnitNetOrder(1);
        budget7.setUnitNetPercentage(1);

        Budget budget8 = new Budget();
        budget8.setBatchSize(3);
        budget8.setBrazilianState(BrazilianState.MG);
        budget8.setCarModel("Car Model");
        budget8.setClient(new Client());
        budget8.setComponents(new HashMap<>());
        budget8.setEditalNumber("42");
        budget8.setId(1L);
        budget8.setManufacturerer(Manufacturer.VOLKSWAGEN);
        budget8.setProductType(ProductType.POLICE_CAR);
        budget8.setResponsibleEmployee("Responsible Employee");
        budget8.setUnitGrossOrder(1);
        budget8.setUnitGrossPercentage(1);
        budget8.setUnitNetOrder(1);
        budget8.setUnitNetPercentage(1);

        LaborCost laborCost8 = new LaborCost();
        laborCost8.setBudgetTime(1L);
        laborCost8.setComponents(new Components());
        laborCost8.setHourTax(HourTax.HOUR_TAX_ISENTO);
        laborCost8.setId(1L);
        laborCost8.setLaborCostName("Labor Cost Name");

        RawMaterial rawMaterial7 = new RawMaterial();
        rawMaterial7.setComponents(new Components());
        rawMaterial7.setId(1L);
        rawMaterial7.setPrice(1L);
        rawMaterial7.setQuantity(1);
        rawMaterial7.setRawMaterialName("Raw Material Name");
        rawMaterial7.setSourceChecked("Source Checked");
        rawMaterial7.setTaxes(new Taxes());

        Components components12 = new Components();
        components12.setBudget(budget8);
        components12.setComponentName("Component Name");
        components12.setId(1L);
        components12.setLaborCost(laborCost8);
        components12.setRawMaterial(rawMaterial7);

        LaborCost laborCost9 = new LaborCost();
        laborCost9.setBudgetTime(1L);
        laborCost9.setComponents(components12);
        laborCost9.setHourTax(HourTax.HOUR_TAX_ISENTO);
        laborCost9.setId(1L);
        laborCost9.setLaborCostName("Labor Cost Name");

        Budget budget9 = new Budget();
        budget9.setBatchSize(3);
        budget9.setBrazilianState(BrazilianState.MG);
        budget9.setCarModel("Car Model");
        budget9.setClient(new Client());
        budget9.setComponents(new HashMap<>());
        budget9.setEditalNumber("42");
        budget9.setId(1L);
        budget9.setManufacturerer(Manufacturer.VOLKSWAGEN);
        budget9.setProductType(ProductType.POLICE_CAR);
        budget9.setResponsibleEmployee("Responsible Employee");
        budget9.setUnitGrossOrder(1);
        budget9.setUnitGrossPercentage(1);
        budget9.setUnitNetOrder(1);
        budget9.setUnitNetPercentage(1);

        LaborCost laborCost10 = new LaborCost();
        laborCost10.setBudgetTime(1L);
        laborCost10.setComponents(new Components());
        laborCost10.setHourTax(HourTax.HOUR_TAX_ISENTO);
        laborCost10.setId(1L);
        laborCost10.setLaborCostName("Labor Cost Name");

        RawMaterial rawMaterial8 = new RawMaterial();
        rawMaterial8.setComponents(new Components());
        rawMaterial8.setId(1L);
        rawMaterial8.setPrice(1L);
        rawMaterial8.setQuantity(1);
        rawMaterial8.setRawMaterialName("Raw Material Name");
        rawMaterial8.setSourceChecked("Source Checked");
        rawMaterial8.setTaxes(new Taxes());

        Components components13 = new Components();
        components13.setBudget(budget9);
        components13.setComponentName("Component Name");
        components13.setId(1L);
        components13.setLaborCost(laborCost10);
        components13.setRawMaterial(rawMaterial8);

        Taxes taxes5 = new Taxes();
        taxes5.setIcms(ICMS.ICMS_ISENTO);
        taxes5.setId(1L);
        taxes5.setIpi(IPI.IPI_ISENTO);
        taxes5.setPis_cofins(PIS_COFINS.PIS_COFINS_ISENTO);

        RawMaterial rawMaterial9 = new RawMaterial();
        rawMaterial9.setComponents(components13);
        rawMaterial9.setId(1L);
        rawMaterial9.setPrice(1L);
        rawMaterial9.setQuantity(1);
        rawMaterial9.setRawMaterialName("Raw Material Name");
        rawMaterial9.setSourceChecked("Source Checked");
        rawMaterial9.setTaxes(taxes5);

        Components components14 = new Components();
        components14.setBudget(budget7);
        components14.setComponentName("Component Name");
        components14.setId(1L);
        components14.setLaborCost(laborCost9);
        components14.setRawMaterial(rawMaterial9);

        Taxes taxes6 = new Taxes();
        taxes6.setIcms(ICMS.ICMS_ISENTO);
        taxes6.setId(1L);
        taxes6.setIpi(IPI.IPI_ISENTO);
        taxes6.setPis_cofins(PIS_COFINS.PIS_COFINS_ISENTO);

        RawMaterial rawMaterial10 = new RawMaterial();
        rawMaterial10.setComponents(components14);
        rawMaterial10.setId(1L);
        rawMaterial10.setPrice(1L);
        rawMaterial10.setQuantity(1);
        rawMaterial10.setRawMaterialName("Raw Material Name");
        rawMaterial10.setSourceChecked("Source Checked");
        rawMaterial10.setTaxes(taxes6);
        Components components15 = mock(Components.class);
        when(components15.getComponentName()).thenReturn("Component Name");
        when(components15.getLaborCost()).thenReturn(laborCost7);
        when(components15.getRawMaterial()).thenReturn(rawMaterial10);

        // Act
        Components actualUpdateComponentsResult = componentsServiceImpl.updateComponents(1L, components15);

        // Assert
        verify(components15).getComponentName();
        verify(components15).getLaborCost();
        verify(components15).getRawMaterial();
        verify(components).setComponentName(Mockito.<String>any());
        verify(components).setLaborCost(Mockito.<LaborCost>any());
        verify(components).setRawMaterial(Mockito.<RawMaterial>any());
        verify(repository).findById(Mockito.<Long>any());
        verify(repository).save(Mockito.<Components>any());
        assertSame(components8, actualUpdateComponentsResult);
    }

    /**
     * Method under test:
     * {@link ComponentsServiceImpl#updateComponents(Long, Components)}
     */
    @Test
    void testUpdateComponents2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.RuntimeException: Components not found
        //       at org.example.costbudgeting.services.impl.ComponentsServiceImpl.lambda$updateComponents$0(ComponentsServiceImpl.java:32)
        //       at java.base/java.util.Optional.orElseThrow(Optional.java:403)
        //       at org.example.costbudgeting.services.impl.ComponentsServiceImpl.updateComponents(ComponentsServiceImpl.java:31)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        ComponentsRepository repository = mock(ComponentsRepository.class);
        Optional<Components> ofResult = Optional.of(mock(Components.class));
        when(repository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        ComponentsServiceImpl componentsServiceImpl = new ComponentsServiceImpl(repository);
        Components components = mock(Components.class);
        when(components.getComponentName()).thenThrow(new RuntimeException("foo"));

        // Act and Assert
        assertThrows(RuntimeException.class, () -> componentsServiceImpl.updateComponents(1L, components));
        verify(components).getComponentName();
        verify(repository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link ComponentsServiceImpl#getComponents(Long)}
     */
    @Test
    void testGetComponents() {
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

        Budget budget2 = new Budget();
        budget2.setBatchSize(3);
        budget2.setBrazilianState(BrazilianState.MG);
        budget2.setCarModel("Car Model");
        budget2.setClient(new Client());
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

        LaborCost laborCost = new LaborCost();
        laborCost.setBudgetTime(1L);
        laborCost.setComponents(new Components());
        laborCost.setHourTax(HourTax.HOUR_TAX_ISENTO);
        laborCost.setId(1L);
        laborCost.setLaborCostName("Labor Cost Name");

        RawMaterial rawMaterial = new RawMaterial();
        rawMaterial.setComponents(new Components());
        rawMaterial.setId(1L);
        rawMaterial.setPrice(1L);
        rawMaterial.setQuantity(1);
        rawMaterial.setRawMaterialName("Raw Material Name");
        rawMaterial.setSourceChecked("Source Checked");
        rawMaterial.setTaxes(new Taxes());

        Components components = new Components();
        components.setBudget(budget2);
        components.setComponentName("Component Name");
        components.setId(1L);
        components.setLaborCost(laborCost);
        components.setRawMaterial(rawMaterial);

        LaborCost laborCost2 = new LaborCost();
        laborCost2.setBudgetTime(1L);
        laborCost2.setComponents(components);
        laborCost2.setHourTax(HourTax.HOUR_TAX_ISENTO);
        laborCost2.setId(1L);
        laborCost2.setLaborCostName("Labor Cost Name");

        Budget budget3 = new Budget();
        budget3.setBatchSize(3);
        budget3.setBrazilianState(BrazilianState.MG);
        budget3.setCarModel("Car Model");
        budget3.setClient(new Client());
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

        LaborCost laborCost3 = new LaborCost();
        laborCost3.setBudgetTime(1L);
        laborCost3.setComponents(new Components());
        laborCost3.setHourTax(HourTax.HOUR_TAX_ISENTO);
        laborCost3.setId(1L);
        laborCost3.setLaborCostName("Labor Cost Name");

        RawMaterial rawMaterial2 = new RawMaterial();
        rawMaterial2.setComponents(new Components());
        rawMaterial2.setId(1L);
        rawMaterial2.setPrice(1L);
        rawMaterial2.setQuantity(1);
        rawMaterial2.setRawMaterialName("Raw Material Name");
        rawMaterial2.setSourceChecked("Source Checked");
        rawMaterial2.setTaxes(new Taxes());

        Components components2 = new Components();
        components2.setBudget(budget3);
        components2.setComponentName("Component Name");
        components2.setId(1L);
        components2.setLaborCost(laborCost3);
        components2.setRawMaterial(rawMaterial2);

        Taxes taxes = new Taxes();
        taxes.setIcms(ICMS.ICMS_ISENTO);
        taxes.setId(1L);
        taxes.setIpi(IPI.IPI_ISENTO);
        taxes.setPis_cofins(PIS_COFINS.PIS_COFINS_ISENTO);

        RawMaterial rawMaterial3 = new RawMaterial();
        rawMaterial3.setComponents(components2);
        rawMaterial3.setId(1L);
        rawMaterial3.setPrice(1L);
        rawMaterial3.setQuantity(1);
        rawMaterial3.setRawMaterialName("Raw Material Name");
        rawMaterial3.setSourceChecked("Source Checked");
        rawMaterial3.setTaxes(taxes);

        Components components3 = new Components();
        components3.setBudget(budget);
        components3.setComponentName("Component Name");
        components3.setId(1L);
        components3.setLaborCost(laborCost2);
        components3.setRawMaterial(rawMaterial3);
        Optional<Components> ofResult = Optional.of(components3);
        when(componentsRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act
        Components actualComponents = componentsServiceImpl.getComponents(1L);

        // Assert
        verify(componentsRepository).findById(Mockito.<Long>any());
        assertSame(components3, actualComponents);
    }
}
