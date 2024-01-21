package org.example.costbudgeting.services;

import org.example.costbudgeting.entities.Budget;

public interface BudgetService {

    Budget createNewBudget(Budget budget);

    void deleteBudget(Long id);

    Budget updateBudget(Long id, Budget budget);

    Budget getBudget(Long id);
}
