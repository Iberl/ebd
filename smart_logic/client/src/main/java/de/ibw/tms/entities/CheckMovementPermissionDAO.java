package de.ibw.tms.entities;


import javax.persistence.*;
import java.util.UUID;

/**
 *  @author iberl@verkehr.tu-darmstadt.de
 *  @version 1.0
 *  @since 2021-05-25
 *
 * Eine Datenbank-Darstellung eines Movmement-Permission-Requests
 */
@Entity(name = "CheckMovementPermission")
public class CheckMovementPermissionDAO {
    @Id
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String CommandType;

    /**
     * Route in der Datenbank fuer den Request
     */
    @OneToOne
    public RouteDAO route;

    /**
     * Movmement-Authority fuer das RBC wird aber vorher von der smartLogic geprueft, aber nicht in Form dieses
     * Datenbankobjektes sondern nach einer Konvertierung
     */
    @OneToOne
    public MaDAO MaAdapter;

    /**
     * Nid-EngineId
     */
    public int iTrainId;

    /**
     * Kommunikations-Id die dieses Objekt als Request inne hat
     */
    public UUID uuid;


    /**
     * Sender TMS-Bezeichnung
     */
    public String tms_id;

    /**
     * Empfangs RBC-Bezeichnung
     */
    public String rbc_id;

    /**
     * Priorisierung dieser Nachricht je niedriger desto wichtiger
     */
    public Long lPriority;



}
