package org.example.costbudgeting.controllers;

import org.example.costbudgeting.entities.costsbreakdown.Components;
import org.example.costbudgeting.entities.costsbreakdown.LaborCost;
import org.example.costbudgeting.entities.costsbreakdown.RawMaterial;
import org.example.costbudgeting.services.ComponentsService;
import org.example.costbudgeting.services.LaborCostService;
import org.example.costbudgeting.services.RawMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ComponentsController {

    ComponentsService componentsService;

    RawMaterialService rawMaterialService;

    LaborCostService laborCostService;

    @Autowired
    public ComponentsController(ComponentsService componentsService, RawMaterialService rawMaterialService, LaborCostService laborCostService) {
        this.componentsService = componentsService;
        this.rawMaterialService = rawMaterialService;
        this.laborCostService = laborCostService;
    }

    @PostMapping("/components")
    public ResponseEntity<Components> createNewComponents(Components components) {
        return new ResponseEntity<>(componentsService.createNewComponents(components), HttpStatus.CREATED);
    }

    @PutMapping("/components/{id}")
    public ResponseEntity<Components> updateComponents(Long id, Components components) {
        return new ResponseEntity<>(componentsService.updateComponents(id, components), HttpStatus.OK);
    }

    @DeleteMapping("/components/{id}")
    public ResponseEntity<Components> deleteComponents(Long id) {
        componentsService.deleteComponents(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/components/{id}")
    public ResponseEntity<Components> getComponents(Long id) {
        return new ResponseEntity<>(componentsService.getComponents(id), HttpStatus.OK);
    }

    @PostMapping("/components/{id}/raw-material")
    public ResponseEntity<RawMaterial> createNewRawMaterial(RawMaterial rawMaterial) {
        return new ResponseEntity<>(rawMaterialService.createNewRawMaterial(rawMaterial), HttpStatus.CREATED);
    }

    @PutMapping("/components/{id}/raw-material/{id}")
    public ResponseEntity<RawMaterial> updateRawMaterial(Long id, RawMaterial rawMaterial) {
        return new ResponseEntity<>(rawMaterialService.updateRawMaterial(id, rawMaterial), HttpStatus.OK);
    }

    @DeleteMapping("/components/{id}/raw-material/{id}")
    public ResponseEntity<RawMaterial> deleteRawMaterial(Long id) {
        rawMaterialService.deleteRawMaterial(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/components/{id}/raw-material/{id}")
    public ResponseEntity<RawMaterial> getRawMaterial(Long id) {
        return new ResponseEntity<>(rawMaterialService.getRawMaterial(id), HttpStatus.OK);
    }

    @GetMapping("/components/{id}/raw-material/{id}/unit-cost")
    public ResponseEntity<Double> getUnitCostOfRawMaterial(Long id) {
        var rawMaterial = rawMaterialService.getRawMaterial(id);
        return new ResponseEntity<>(rawMaterial.getUnitCostOfRawMaterial(), HttpStatus.OK);
    }

    @GetMapping("/components/{id}/raw-material/{id}/total-cost")
    public ResponseEntity<Double> getTotalCostOfRawMaterials(Long id) {
        var rawMaterial = rawMaterialService.getRawMaterial(id);
        return new ResponseEntity<>(rawMaterial.getTotalCostOfRawMaterials(), HttpStatus.OK);
    }

    @PostMapping("/components/{id}/labor-cost")
    public ResponseEntity<LaborCost> createNewLaborCost(LaborCost laborCost) {
        return new ResponseEntity<>(laborCostService.createNewLaborCost(laborCost), HttpStatus.CREATED);
    }

    @PutMapping("/components/{id}/labor-cost/{id}")
    public ResponseEntity<LaborCost> updateLaborCost(Long id, LaborCost laborCost) {
        return new ResponseEntity<>(laborCostService.updateLaborCost(id, laborCost), HttpStatus.OK);
    }

    @DeleteMapping("/components/{id}/labor-cost/{id}")
    public ResponseEntity<LaborCost> deleteLaborCost(Long id) {
        laborCostService.deleteLaborCost(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/components/{id}/labor-cost/{id}")
    public ResponseEntity<LaborCost> getLaborCost(Long id) {
        return new ResponseEntity<>(laborCostService.getLaborCost(id), HttpStatus.OK);
    }

    @GetMapping("/components/{id}/labor-cost/{id}/unit-cost")
    public ResponseEntity<Double> getUnitCostOfLaborCost(Long id) {
        LaborCost laborCost = laborCostService.getLaborCost(id);
        return new ResponseEntity<>(laborCost.getTotalLaborCost(), HttpStatus.OK);
    }

}
