package org.glebindustries.veterinary_application.repositories;

import org.glebindustries.veterinary_application.models.Clinic;
import org.springframework.data.repository.CrudRepository;

public interface ClinicRepository extends CrudRepository<Clinic, String> {
}
