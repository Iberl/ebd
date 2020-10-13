package de.ibw.tms.ma.net.elements;

import de.ibw.tms.ma.common.NetworkResource;

import java.io.Serializable;
import java.security.InvalidParameterException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Nachbarschaftsbeziehung
 *
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-10-12
 */
public class Relation extends NetworkResource implements Serializable {
    private List<INetElement> neighbourElements;

    /**
     * Relation muss mindestens ein Element enhalten
     * @param elements - Liste mit mindestens einem Element
     */
    public Relation(List<INetElement> elements) {

        if(elements.size() <= 1) {
            throw new InvalidParameterException("Relations size must be greather than 0");
        }
        defaultInit("NeighbourRelation");
        neighbourElements = elements;
    }

}
