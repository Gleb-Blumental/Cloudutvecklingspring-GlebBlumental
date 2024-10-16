package org.glebindustries.veterinary_application.repositories;

import org.glebindustries.veterinary_application.models.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animal, String> {
}
