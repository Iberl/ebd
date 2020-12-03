package de.ibw.tms.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeTaskRepository extends CrudRepository<TimeTaskDAO, String> {


}
