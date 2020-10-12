package de.ibw.tms.ma.common;

import java.sql.Timestamp;
import java.util.Date;
/**
 *
 * Grundlegendes Objekt
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-10-12
 */
public abstract class DefaultObject implements IBaseObject {
    private String sSystemName = IBaseObject.sName;
    private Timestamp lastUpdated = IBaseObject.lastUpdated;
    private String sComment = IBaseObject.sComment;
    private Date validFromDate = IBaseObject.validFrom;
    private Date validToDate = IBaseObject.validTo;

    public void defaultInit(String sName) {
        this.sSystemName = sName;
        this.lastUpdated = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public String getName() {
        return this.sSystemName;
    }

    @Override
    public Timestamp getLastUpdated() {
        return this.lastUpdated;
    }

    @Override
    public String getComment() {
        return this.sComment;
    }

    @Override
    public Date getValidFrom() {
        return this.validFromDate;
    }

    @Override
    public Date getValidTo() {
        return this.validToDate;
    }

    @Override
    public void setName(String s) {
        this.sSystemName = s;
    }

    @Override
    public void setLastUpdated(Timestamp T) {
        this.lastUpdated = T;
    }

    @Override
    public void setComment(String s) {
        this.sComment = s;
    }

    @Override
    public void setValidFrom(Date validFromDate) {
        this.validFromDate = validFromDate;
    }

    @Override
    public void setValidTo(Date validToDate) {
        this.validToDate = validToDate;
    }
}
