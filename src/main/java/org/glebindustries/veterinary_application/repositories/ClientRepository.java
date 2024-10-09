package org.glebindustries.veterinary_application.repositories;


import org.glebindustries.veterinary_application.models.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, String> {
}
