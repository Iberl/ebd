package de.ibw.tms.trackplan;

public abstract class EnumModel {

    private EnumField SingleSelection = null;

    public class EnumField {
        public Enum Item;
        public String sName;
        public String toString() {
            return sName;
        }
        public EnumField(Enum It, String sName) {
            this.Item = It;
            this.sName = sName;
        }

    }

    public EnumField getSingleSelection() {
        return SingleSelection;
    }

    public void setSingleSelection(EnumField singleSelection) {
        SingleSelection = singleSelection;
    }

    abstract public EnumField[] getEnumMappingList();

    public EnumField getFieldByDataEnum(Enum E) {
        for(EnumModel.EnumField Field : this.getEnumMappingList()) {
            if(Field.Item == E) {
                return Field;
            }
        }
        return null;
    }



}
