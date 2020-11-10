package de.ibw.tms.ma.net.elements;

import de.ibw.tms.ma.common.NetworkResource;

import java.io.Serializable;
import java.security.InvalidParameterException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Nachbarschaftsbeziehung
 * Im railMl gibt es nur Positioned Relation
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-10-12
 */
@Deprecated
public class Relation extends NetworkResource implements Serializable {
    private List<INetElement> neighbourElements;


    public Relation(String sName) {
        super(sName);
    }
}
