package org.example.costbudgeting.services.impl;

import org.example.costbudgeting.entities.costsbreakdown.Components;
import org.example.costbudgeting.repositories.ComponentsRepository;
import org.example.costbudgeting.services.ComponentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComponentsServiceImpl implements ComponentsService {

        private final ComponentsRepository repository;

        @Autowired
        public ComponentsServiceImpl(ComponentsRepository repository) {
            this.repository = repository;
        }

        @Override
        public Components createNewComponents(Components components) {
            return repository.save(components);
        }

        @Override
        public void deleteComponents(Long id) {
            repository.deleteById(id);
        }

        @Override
        public Components updateComponents(Long id, Components components) {
            Components componentsToUpdate = repository.findById(id).orElseThrow(() ->
                    new RuntimeException("Components not found"));
            componentsToUpdate.setComponentName(components.getComponentName());
            componentsToUpdate.setLaborCost(components.getLaborCost());
            componentsToUpdate.setRawMaterial(components.getRawMaterial());
            return repository.save(componentsToUpdate);
        }

        @Override
        public Components getComponents(Long id) {
            return repository.findById(id).orElseThrow(() -> new RuntimeException("Components not found"));
        }
}
