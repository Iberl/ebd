package de.ibw.tms.ma.common;

import de.ibw.rtm.intf.IRTMNetworkResource;
import de.ibw.rtm.intf.IRTMValidity;
import org.apache.commons.lang3.NotImplementedException;
import org.railMl.rtm4rail.RTMNetworkResource;
import org.railMl.rtm4rail.RTMValidity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Oberklasse f&uuml;r Relation, Netzelemente oder Bezugssysteme
 *
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-10-12
 */
public abstract class NetworkResource extends DefaultObject implements IRTMNetworkResource {

    public NetworkResource(String sName) {
        super(sName);
    }

    @Override
    public List<RTMValidity> getIsValid()  {
        RTMValidity ValidTime = new RTMValidity();
        GregorianCalendar from = new GregorianCalendar();
        from.setTimeInMillis(this.getValidFrom().getTime());
        GregorianCalendar to = new GregorianCalendar();
        to.setTimeInMillis(this.getValidTo().getTime());
        XMLGregorianCalendar fromValidCalendar = null;
        try {
            fromValidCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(from);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        XMLGregorianCalendar toValidCalendar = null;
        try {
            toValidCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(to);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        ValidTime.setFrom(fromValidCalendar);
        ValidTime.setTo(toValidCalendar);
        ArrayList<RTMValidity> result = new ArrayList<>();
        return result;
    }


    @Override
    public String getId() {
        return this.getUuid().toString();
    }

    @Override
    public void setId(String value) {

        throw new NotImplementedException("Id is unique set once");
    }
}
