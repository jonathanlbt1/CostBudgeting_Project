package org.example.costbudgeting.services;

import org.example.costbudgeting.entities.costsbreakdown.RawMaterial;

public interface RawMaterialService {

    RawMaterial createNewRawMaterial(RawMaterial rawMaterial);

    void deleteRawMaterial(Long id);

    RawMaterial updateRawMaterial(Long id, RawMaterial rawMaterial);

    RawMaterial getRawMaterial(Long id);
}
