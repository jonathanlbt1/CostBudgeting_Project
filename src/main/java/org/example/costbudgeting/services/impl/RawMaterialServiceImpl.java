package org.example.costbudgeting.services.impl;

import org.example.costbudgeting.entities.costsbreakdown.RawMaterial;
import org.example.costbudgeting.repositories.RawMaterialRepository;
import org.example.costbudgeting.services.RawMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RawMaterialServiceImpl implements RawMaterialService {

    RawMaterialRepository rawMaterialRepository;

    @Autowired
    public RawMaterialServiceImpl(RawMaterialRepository rawMaterialRepository) {
        this.rawMaterialRepository = rawMaterialRepository;
    }

    public RawMaterial createNewRawMaterial(RawMaterial rawMaterial) {
        return rawMaterialRepository.save(rawMaterial);
    }

    public void deleteRawMaterial(Long id) {
        rawMaterialRepository.deleteById(id);
    }

    public RawMaterial updateRawMaterial(Long id, RawMaterial rawMaterial) {
        RawMaterial rawMaterialToUpdate = rawMaterialRepository.findById(id).get();
        rawMaterialToUpdate.setRawMaterialName(rawMaterial.getRawMaterialName());
        rawMaterialToUpdate.setSourceChecked(rawMaterial.getSourceChecked());
        rawMaterialToUpdate.setPrice(rawMaterial.getPrice());
        rawMaterialToUpdate.setTaxes(rawMaterial.getTaxes());
        rawMaterialToUpdate.setQuantity(rawMaterial.getQuantity());
        return rawMaterialRepository.save(rawMaterialToUpdate);
    }

    public RawMaterial getRawMaterial(Long id) {
        return rawMaterialRepository.findById(id).get();
    }

}
