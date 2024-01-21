package org.example.costbudgeting.repositories;

import org.example.costbudgeting.entities.costsbreakdown.LaborCost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaborCostRepository extends JpaRepository<LaborCost, Long> {

}
