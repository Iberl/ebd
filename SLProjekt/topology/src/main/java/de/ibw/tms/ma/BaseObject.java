package de.ibw.tms.ma;

import org.apache.commons.lang3.time.DateUtils;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;



public interface BaseObject {
    UUID id = UUID.randomUUID();
    String sName = "Base";
    Timestamp lastUpdated = new Timestamp(System.currentTimeMillis());
    String sComment = "";
    Date validFrom = new Date(System.currentTimeMillis());
    Date validTo = DateUtils.addMonths(new Date(), 3);

}
