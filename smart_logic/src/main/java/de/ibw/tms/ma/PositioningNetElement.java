package de.ibw.tms.ma;

import de.ibw.tms.ma.common.DefaultObject;
import de.ibw.tms.ma.common.IBaseObject;
import de.ibw.tms.ma.net.elements.CompositedNetElement;

public class PositioningNetElement extends CompositedNetElement {
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
