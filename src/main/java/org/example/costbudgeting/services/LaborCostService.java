package org.example.costbudgeting.services;

import org.example.costbudgeting.entities.costsbreakdown.LaborCost;

public interface LaborCostService {

    LaborCost createNewLaborCost(LaborCost laborCost);

    void deleteLaborCost(Long id);

    LaborCost updateLaborCost(Long id, LaborCost laborCost);

    LaborCost getLaborCost(Long id);
}
