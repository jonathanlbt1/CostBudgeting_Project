package org.example.costbudgeting.services.impl;

import org.example.costbudgeting.entities.Budget;
import org.example.costbudgeting.repositories.BudgetRepository;
import org.example.costbudgeting.services.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetServiceImpl implements BudgetService {
    private final BudgetRepository budgetRepository;

    @Autowired
    public BudgetServiceImpl(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    public Budget createNewBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    public void deleteBudget(Long id) {
        budgetRepository.deleteById(id);
    }

    public Budget updateBudget(Long id, Budget budget) {
        var budgetToUpdate = budgetRepository.findById(id).get();
        budgetToUpdate.setClient(budget.getClient());
        budgetToUpdate.setBatchSize(budget.getBatchSize());
        budgetToUpdate.setBrazilianState(budget.getBrazilianState());
        budgetToUpdate.setCarModel(budget.getCarModel());
        budgetToUpdate.setManufacturerer(budget.getManufacturerer());
        budgetToUpdate.setEditalNumber(budget.getEditalNumber());
        budgetToUpdate.setProductType(budget.getProductType());
        budgetToUpdate.setResponsibleEmployee(budget.getResponsibleEmployee());
        budgetToUpdate.setUnitGrossOrder(budget.getUnitGrossOrder());
        budgetToUpdate.setUnitNetOrder(budget.getUnitNetOrder());
        budgetToUpdate.setUnitNetPercentage(budget.getUnitNetPercentage());
        budgetToUpdate.setComponents(budget.getComponents());
        return budgetRepository.save(budgetToUpdate);
    }

    public Budget getBudget(Long id) {
        return budgetRepository.findById(id).get();
    }
}
