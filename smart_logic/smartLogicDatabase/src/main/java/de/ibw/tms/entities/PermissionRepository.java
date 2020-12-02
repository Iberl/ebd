package de.ibw.tms.entities;

import de.ibw.tms.entities.CheckMovmentPermissionDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends CrudRepository<CheckMovmentPermissionDAO, String> {


}
