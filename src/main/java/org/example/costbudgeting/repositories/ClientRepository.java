package org.example.costbudgeting.repositories;

import org.example.costbudgeting.entities.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {


}
