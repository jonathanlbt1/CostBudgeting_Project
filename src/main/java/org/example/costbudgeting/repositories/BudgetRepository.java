package org.example.costbudgeting.repositories;

import jakarta.persistence.Table;
import org.example.costbudgeting.entities.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Table(name = "budgets")
@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {

}
