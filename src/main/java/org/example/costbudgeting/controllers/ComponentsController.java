package org.example.costbudgeting.controllers;

import org.example.costbudgeting.entities.costsbreakdown.Components;
import org.example.costbudgeting.entities.costsbreakdown.LaborCost;
import org.example.costbudgeting.entities.costsbreakdown.RawMaterial;
import org.example.costbudgeting.services.ComponentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ComponentsController {

    ComponentsService componentsService;

    RawMaterial rawMaterial;

    LaborCost laborCost;

    @Autowired
    public ComponentsController(ComponentsService componentsService, RawMaterial rawMaterial, LaborCost laborCost) {
        this.componentsService = componentsService;
        this.rawMaterial = rawMaterial;
        this.laborCost = laborCost;
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



}
