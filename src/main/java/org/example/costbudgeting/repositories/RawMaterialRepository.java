package org.example.costbudgeting.repositories;

import org.example.costbudgeting.entities.costsbreakdown.RawMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RawMaterialRepository extends JpaRepository<RawMaterial, Long> {
}
