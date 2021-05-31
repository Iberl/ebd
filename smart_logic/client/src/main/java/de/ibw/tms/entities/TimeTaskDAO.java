package de.ibw.tms.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *  @author iberl@verkehr.tu-darmstadt.de
 *  @version 1.0
 *  @since 2021-05-28
 *
 *  Eine Datenbankzugriffsklasse, die Ma-Permission und TESC-Befehle haelt.
 *  Die Nachrichten in der Datenbank werden nach einem Timout geschickt.
 *  Der Timer startet soblad der erste Position-Report den Client erreicht.
 *
 *  Dieser Task kann entweder eine MA-Permission-Request oder einen Tesc-Befehl verwalten.
 *  Es ist auch moeglich beide Befehlsarten in einem TimeTask zu halten. Das ist aber urspruenglich nicht vorgesehen.
 */
@Entity(name = "TimeTask")
public class TimeTaskDAO {
    @Id
    private String id;

    /**
     * Diese Objekt haelt die Darstellung eines Movment-Permission-Request, wie er aus der Datenbank entnommen wurde.
     */
    @OneToOne
    public CheckMovementPermissionDAO CheckPermission;

    /**
     * Dieses Objekt haelt einen TESC-Request, wie er aus der Datenbank entnommen wird.
     */
    @OneToOne
    public DbdCommandDAO CheckDbd;

    /**
     * Zeit in sekunden, er gibt an, wann seit Szenariostart dieser TimeTask gesendet wird
     */
    public double SendTimeSinceStartInSeconds;



    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
