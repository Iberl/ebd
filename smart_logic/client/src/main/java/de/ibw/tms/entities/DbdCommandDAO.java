package de.ibw.tms.entities;

import de.ibw.tms.ma.physical.TrackElementStatus;

import javax.persistence.*;
import java.util.*;

/**
 * Ein Stellbefehl in der Datenbankdarstellung. Er geht vom TMS an die smartLogic zur Pruefung und wird dann
 * im Stellwerk umgesetzt.
 */
@Entity(name = "DbdCommand")
public class DbdCommandDAO {
    @Id
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gibt an dass dieses Objekt eine DBD-Befehl realisiert
     */
    public String CommandType;

    public String getId() {
        return id;
    }

    /**
     * Gibt die Kommunikations-Id die dieser Befehl haben soll vor.
     */
    public UUID uuid;

    /**
     * Bezeichnung nach der Definition der ETCS-Weichenbezeichnung
     */
    public String sId;
    /**
     * Prioritaet dieser Nachricht
     */
    public Long lPriority;

    /**
     * Liste von Status. Die Lage der Weiche (Links Oder Rechts)
     * Eine DKW kann zwei Weichenlagen haben:
     * (LINKS-LINKS oder RECHTS-LINKS usw.) Die niedrigere ETCS-Weichenbezeichnung innerhalb der DKW ist das erste
     * Listenelement.
     */
    @ElementCollection(fetch = FetchType.EAGER, targetClass=TrackElementStatus.Status.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "tesc_status", joinColumns =  @JoinColumn(name = "dbd_command_id"))
    @OrderColumn()
    public List<TrackElementStatus.Status> statusList;



}
