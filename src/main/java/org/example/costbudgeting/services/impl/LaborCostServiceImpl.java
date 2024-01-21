package org.example.costbudgeting.services.impl;

import org.example.costbudgeting.entities.costsbreakdown.LaborCost;
import org.example.costbudgeting.repositories.LaborCostRepository;
import org.example.costbudgeting.services.LaborCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaborCostServiceImpl implements LaborCostService {

    private final LaborCostRepository laborCostRepository;

    @Autowired
    public LaborCostServiceImpl(LaborCostRepository laborCostRepository) {
        this.laborCostRepository = laborCostRepository;
    }

    public LaborCost createNewLaborCost(LaborCost laborCost) {
        return laborCostRepository.save(laborCost);
    }

    public void deleteLaborCost(Long id) {
        laborCostRepository.deleteById(id);
    }

    public LaborCost updateLaborCost(Long id, LaborCost laborCost) {
        LaborCost laborCostToUpdate = laborCostRepository.findById(id).get();
        laborCostToUpdate.setHourTax(laborCost.getHourTax());
        laborCostToUpdate.setBudgetTime(laborCost.getBudgetTime());
        laborCostToUpdate.setLaborCostName(laborCost.getLaborCostName());
        return laborCostRepository.save(laborCostToUpdate);
    }

    public LaborCost getLaborCost(Long id) {
        return laborCostRepository.findById(id).get();
    }
}
