package org.example.costbudgeting.services;

import org.example.costbudgeting.entities.costsbreakdown.Components;

public interface ComponentsService {

    Components createNewComponents(Components components);

    void deleteComponents(Long id);

    Components updateComponents(Long id, Components components);

    Components getComponents(Long id);

}
