package de.ibw.tms.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *  @author iberl@verkehr.tu-darmstadt.de
 *  @version 1.0
 *  @since 2021-05-28
 *
 *  Dieses Repository verwaltet alle Datenbankoperationen durch die die TimeTasks aus der Datenbank in das TMS-Programm
 *  geladen werden können.
 */
@Repository
public interface TimeTaskRepository extends CrudRepository<TimeTaskDAO, String> {


}
