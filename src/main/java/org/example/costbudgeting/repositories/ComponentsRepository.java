package org.example.costbudgeting.repositories;

import org.example.costbudgeting.entities.costsbreakdown.Components;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentsRepository extends JpaRepository<Components, Long> {
}
