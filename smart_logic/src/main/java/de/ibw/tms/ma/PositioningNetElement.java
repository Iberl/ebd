package de.ibw.tms.ma;

import de.ibw.tms.ma.common.IBaseObject;

public class PositioningNetElement implements IBaseObject {
    private EntityLocation entityLocation;
    private SectionOfLine sectionOfLine;


    public EntityLocation getEntityLocation() {
        return entityLocation;
    }

    public void setEntityLocation(EntityLocation entityLocation) {
        this.entityLocation = entityLocation;
    }

    public SectionOfLine getSectionOfLine() {
        return sectionOfLine;
    }

    public void setSectionOfLine(SectionOfLine sectionOfLine) {
        this.sectionOfLine = sectionOfLine;
    }
}
