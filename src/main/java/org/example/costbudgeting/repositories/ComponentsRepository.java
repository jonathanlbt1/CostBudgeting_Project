package org.example.costbudgeting.repositories;

import org.example.costbudgeting.entities.costsbreakdown.Components;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentsRepository extends JpaRepository<Components, Long> {
}
