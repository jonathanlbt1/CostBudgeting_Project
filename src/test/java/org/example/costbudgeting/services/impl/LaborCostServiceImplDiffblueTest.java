package org.example.costbudgeting.services.impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doNothing;
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
import org.example.costbudgeting.repositories.LaborCostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {LaborCostServiceImpl.class})
@ExtendWith(SpringExtension.class)
class LaborCostServiceImplDiffblueTest {
    @MockBean
    private LaborCostRepository laborCostRepository;

    @Autowired
    private LaborCostServiceImpl laborCostServiceImpl;

    /**
     * Method under test: {@link LaborCostServiceImpl#createNewLaborCost(LaborCost)}
     */
    @Test
    void testCreateNewLaborCost() {
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

        LaborCost laborCost4 = new LaborCost();
        laborCost4.setBudgetTime(1L);
        laborCost4.setComponents(components3);
        laborCost4.setHourTax(HourTax.HOUR_TAX_ISENTO);
        laborCost4.setId(1L);
        laborCost4.setLaborCostName("Labor Cost Name");
        when(laborCostRepository.save(Mockito.<LaborCost>any())).thenReturn(laborCost4);

        Client client2 = new Client();
        client2.setAddress(new Address());
        client2.setEmail("jane.doe@example.org");
        client2.setId(1L);
        client2.setName("Name");
        client2.setPhone("6625550144");

        Budget budget4 = new Budget();
        budget4.setBatchSize(3);
        budget4.setBrazilianState(BrazilianState.MG);
        budget4.setCarModel("Car Model");
        budget4.setClient(client2);
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

        Components components4 = new Components();
        components4.setBudget(new Budget());
        components4.setComponentName("Component Name");
        components4.setId(1L);
        components4.setLaborCost(new LaborCost());
        components4.setRawMaterial(new RawMaterial());

        LaborCost laborCost5 = new LaborCost();
        laborCost5.setBudgetTime(1L);
        laborCost5.setComponents(components4);
        laborCost5.setHourTax(HourTax.HOUR_TAX_ISENTO);
        laborCost5.setId(1L);
        laborCost5.setLaborCostName("Labor Cost Name");

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

        RawMaterial rawMaterial4 = new RawMaterial();
        rawMaterial4.setComponents(components5);
        rawMaterial4.setId(1L);
        rawMaterial4.setPrice(1L);
        rawMaterial4.setQuantity(1);
        rawMaterial4.setRawMaterialName("Raw Material Name");
        rawMaterial4.setSourceChecked("Source Checked");
        rawMaterial4.setTaxes(taxes2);

        Components components6 = new Components();
        components6.setBudget(budget4);
        components6.setComponentName("Component Name");
        components6.setId(1L);
        components6.setLaborCost(laborCost5);
        components6.setRawMaterial(rawMaterial4);

        LaborCost laborCost6 = new LaborCost();
        laborCost6.setBudgetTime(1L);
        laborCost6.setComponents(components6);
        laborCost6.setHourTax(HourTax.HOUR_TAX_ISENTO);
        laborCost6.setId(1L);
        laborCost6.setLaborCostName("Labor Cost Name");

        // Act
        LaborCost actualCreateNewLaborCostResult = laborCostServiceImpl.createNewLaborCost(laborCost6);

        // Assert
        verify(laborCostRepository).save(Mockito.<LaborCost>any());
        assertSame(laborCost4, actualCreateNewLaborCostResult);
    }

    /**
     * Method under test: {@link LaborCostServiceImpl#deleteLaborCost(Long)}
     */
    @Test
    void testDeleteLaborCost() {
        // Arrange
        doNothing().when(laborCostRepository).deleteById(Mockito.<Long>any());

        // Act
        laborCostServiceImpl.deleteLaborCost(1L);

        // Assert that nothing has changed
        verify(laborCostRepository).deleteById(Mockito.<Long>any());
    }

    /**
     * Method under test:
     * {@link LaborCostServiceImpl#updateLaborCost(Long, LaborCost)}
     */
    @Test
    void testUpdateLaborCost() {
        // Arrange
        Client client = new Client();
        client.setAddress(new Address());
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
        components3.setBudget(budget);
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
        Optional<LaborCost> ofResult = Optional.of(laborCost2);

        Address address = new Address();
        address.setCity("Oxford");
        address.setComplement("Complement");
        address.setId(1L);
        address.setNeighborhood("Neighborhood");
        address.setNumber("42");
        address.setState(BrazilianState.MG);
        address.setStreet("Street");
        address.setZipCode("21654");

        Client client2 = new Client();
        client2.setAddress(address);
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

        Components components4 = new Components();
        components4.setBudget(budget3);
        components4.setComponentName("Component Name");
        components4.setId(1L);
        components4.setLaborCost(laborCost3);
        components4.setRawMaterial(rawMaterial2);

        LaborCost laborCost4 = new LaborCost();
        laborCost4.setBudgetTime(1L);
        laborCost4.setComponents(components4);
        laborCost4.setHourTax(HourTax.HOUR_TAX_ISENTO);
        laborCost4.setId(1L);
        laborCost4.setLaborCostName("Labor Cost Name");

        Budget budget4 = new Budget();
        budget4.setBatchSize(3);
        budget4.setBrazilianState(BrazilianState.MG);
        budget4.setCarModel("Car Model");
        budget4.setClient(new Client());
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

        LaborCost laborCost5 = new LaborCost();
        laborCost5.setBudgetTime(1L);
        laborCost5.setComponents(new Components());
        laborCost5.setHourTax(HourTax.HOUR_TAX_ISENTO);
        laborCost5.setId(1L);
        laborCost5.setLaborCostName("Labor Cost Name");

        RawMaterial rawMaterial3 = new RawMaterial();
        rawMaterial3.setComponents(new Components());
        rawMaterial3.setId(1L);
        rawMaterial3.setPrice(1L);
        rawMaterial3.setQuantity(1);
        rawMaterial3.setRawMaterialName("Raw Material Name");
        rawMaterial3.setSourceChecked("Source Checked");
        rawMaterial3.setTaxes(new Taxes());

        Components components5 = new Components();
        components5.setBudget(budget4);
        components5.setComponentName("Component Name");
        components5.setId(1L);
        components5.setLaborCost(laborCost5);
        components5.setRawMaterial(rawMaterial3);

        Taxes taxes2 = new Taxes();
        taxes2.setIcms(ICMS.ICMS_ISENTO);
        taxes2.setId(1L);
        taxes2.setIpi(IPI.IPI_ISENTO);
        taxes2.setPis_cofins(PIS_COFINS.PIS_COFINS_ISENTO);

        RawMaterial rawMaterial4 = new RawMaterial();
        rawMaterial4.setComponents(components5);
        rawMaterial4.setId(1L);
        rawMaterial4.setPrice(1L);
        rawMaterial4.setQuantity(1);
        rawMaterial4.setRawMaterialName("Raw Material Name");
        rawMaterial4.setSourceChecked("Source Checked");
        rawMaterial4.setTaxes(taxes2);

        Components components6 = new Components();
        components6.setBudget(budget2);
        components6.setComponentName("Component Name");
        components6.setId(1L);
        components6.setLaborCost(laborCost4);
        components6.setRawMaterial(rawMaterial4);

        LaborCost laborCost6 = new LaborCost();
        laborCost6.setBudgetTime(1L);
        laborCost6.setComponents(components6);
        laborCost6.setHourTax(HourTax.HOUR_TAX_ISENTO);
        laborCost6.setId(1L);
        laborCost6.setLaborCostName("Labor Cost Name");
        when(laborCostRepository.save(Mockito.<LaborCost>any())).thenReturn(laborCost6);
        when(laborCostRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        Client client3 = new Client();
        client3.setAddress(new Address());
        client3.setEmail("jane.doe@example.org");
        client3.setId(1L);
        client3.setName("Name");
        client3.setPhone("6625550144");

        Budget budget5 = new Budget();
        budget5.setBatchSize(3);
        budget5.setBrazilianState(BrazilianState.MG);
        budget5.setCarModel("Car Model");
        budget5.setClient(client3);
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

        Components components7 = new Components();
        components7.setBudget(new Budget());
        components7.setComponentName("Component Name");
        components7.setId(1L);
        components7.setLaborCost(new LaborCost());
        components7.setRawMaterial(new RawMaterial());

        LaborCost laborCost7 = new LaborCost();
        laborCost7.setBudgetTime(1L);
        laborCost7.setComponents(components7);
        laborCost7.setHourTax(HourTax.HOUR_TAX_ISENTO);
        laborCost7.setId(1L);
        laborCost7.setLaborCostName("Labor Cost Name");

        Components components8 = new Components();
        components8.setBudget(new Budget());
        components8.setComponentName("Component Name");
        components8.setId(1L);
        components8.setLaborCost(new LaborCost());
        components8.setRawMaterial(new RawMaterial());

        Taxes taxes3 = new Taxes();
        taxes3.setIcms(ICMS.ICMS_ISENTO);
        taxes3.setId(1L);
        taxes3.setIpi(IPI.IPI_ISENTO);
        taxes3.setPis_cofins(PIS_COFINS.PIS_COFINS_ISENTO);

        RawMaterial rawMaterial5 = new RawMaterial();
        rawMaterial5.setComponents(components8);
        rawMaterial5.setId(1L);
        rawMaterial5.setPrice(1L);
        rawMaterial5.setQuantity(1);
        rawMaterial5.setRawMaterialName("Raw Material Name");
        rawMaterial5.setSourceChecked("Source Checked");
        rawMaterial5.setTaxes(taxes3);

        Components components9 = new Components();
        components9.setBudget(budget5);
        components9.setComponentName("Component Name");
        components9.setId(1L);
        components9.setLaborCost(laborCost7);
        components9.setRawMaterial(rawMaterial5);

        LaborCost laborCost8 = new LaborCost();
        laborCost8.setBudgetTime(1L);
        laborCost8.setComponents(components9);
        laborCost8.setHourTax(HourTax.HOUR_TAX_ISENTO);
        laborCost8.setId(1L);
        laborCost8.setLaborCostName("Labor Cost Name");

        // Act
        LaborCost actualUpdateLaborCostResult = laborCostServiceImpl.updateLaborCost(1L, laborCost8);

        // Assert
        verify(laborCostRepository).findById(Mockito.<Long>any());
        verify(laborCostRepository).save(Mockito.<LaborCost>any());
        assertSame(laborCost6, actualUpdateLaborCostResult);
    }

    /**
     * Method under test: {@link LaborCostServiceImpl#getLaborCost(Long)}
     */
    @Test
    void testGetLaborCost() {
        // Arrange
        Client client = new Client();
        client.setAddress(new Address());
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
        components3.setBudget(budget);
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
        Optional<LaborCost> ofResult = Optional.of(laborCost2);
        when(laborCostRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        // Act
        LaborCost actualLaborCost = laborCostServiceImpl.getLaborCost(1L);

        // Assert
        verify(laborCostRepository).findById(Mockito.<Long>any());
        assertSame(laborCost2, actualLaborCost);
    }
}
