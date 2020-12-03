package de.ibw.tms.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends CrudRepository<CheckMovementPermissionDAO, String> {


}
