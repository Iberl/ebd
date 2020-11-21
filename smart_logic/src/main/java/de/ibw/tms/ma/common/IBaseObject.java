package de.ibw.tms.ma.common;

import de.ibw.rtm.intf.IRTMBaseObject;
import ebd.SlConfigHandler;
import org.apache.commons.lang3.time.DateUtils;


import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;


public interface IBaseObject extends IRTMBaseObject {
    UUID id = UUID.randomUUID();
    String sName = "Base";
    Timestamp lastUpdated = new Timestamp(System.currentTimeMillis());
    String sComment = "";
    Date validFrom = new Date(System.currentTimeMillis());
    Date validTo = DateUtils.addMonths(new Date(), SlConfigHandler.getInstance().defaultAmountOfMonthBaseObjectIsValidTo);

    default UUID getUuid() {
        return id;
    }
    default String getName() {
        return sName;
    }
    default Timestamp getLastUpdated() {
        return lastUpdated;
    }
    default String getComment() {
        return sComment;
    }
    default Date getValidFrom() {
        return validFrom;
    }
    default Date getValidTo() {
        return validTo;
    }
    void setName(String s);
    void setLastUpdated(Timestamp T);
    void setComment(String s);
    void setValidFrom(Date validFromDate);
    void setValidTo(Date validToDate);





}
