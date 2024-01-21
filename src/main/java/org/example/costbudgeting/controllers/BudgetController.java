package org.example.costbudgeting.controllers;

import org.example.costbudgeting.entities.Budget;
import org.example.costbudgeting.services.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BudgetController {

    BudgetService budgetService;

    @Autowired
    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @PostMapping("/budgets")
    public ResponseEntity<Budget> createNewBudget(Budget budget) {
        return new ResponseEntity<>(budgetService.createNewBudget(budget), HttpStatus.CREATED);
    }

    @GetMapping("/budgets/{id}")
    public ResponseEntity<Budget> getBudget(Long id) {
        return new ResponseEntity<>(budgetService.getBudget(id), HttpStatus.OK);
    }

    @PutMapping("/budgets/{id}")
    public ResponseEntity<Budget> updateBudget(Long id, Budget budget) {
        return new ResponseEntity<>(budgetService.updateBudget(id, budget), HttpStatus.OK);
    }

    @DeleteMapping("/budgets/{id}")
    public ResponseEntity<Budget> deleteBudget(Long id) {
        budgetService.deleteBudget(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
