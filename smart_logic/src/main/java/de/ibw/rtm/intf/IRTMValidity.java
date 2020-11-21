package de.ibw.rtm.intf;

import javax.xml.datatype.XMLGregorianCalendar;

public interface IRTMValidity {
    XMLGregorianCalendar getFrom();

    void setFrom(XMLGregorianCalendar value);

    XMLGregorianCalendar getTo();

    void setTo(XMLGregorianCalendar value);
}
