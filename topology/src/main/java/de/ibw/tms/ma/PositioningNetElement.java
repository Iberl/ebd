package de.ibw.tms.ma;

public class PositioningNetElement implements BaseObject {
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
