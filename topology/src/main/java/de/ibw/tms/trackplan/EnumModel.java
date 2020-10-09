package de.ibw.tms.trackplan;
/**
 * Dieses Model verwaltet Enums zum generischen verarbeiten.
 * Wird derzeit bei Weichen eingesetzt.
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 *
 * @version 0.3
 * @since 2020-08-12
 */
public abstract class EnumModel {

    private EnumField SingleSelection = null;

    /**
     * Verwalten einen konkreten Wert eines Enums
     */
    public class EnumField {
        /**
         * Gerade aktiver Wert
         */
        public Enum Item;
        /**
         * Gerade aktiver Wert als String
         */
        public String sName;

        /**
         * Gibt gerade aktiven EnumWert als String wider.
         * @return String
         */
        public String toString() {
            return sName;
        }

        /**
         * Erstellt einen Value eines Enums
         * @param It {@link Enum} Ein Wert eines Enums
         * @param sName {@link String} - Enum-Wert als String
         */
        public EnumField(Enum It, String sName) {
            this.Item = It;
            this.sName = sName;
        }

    }

    /**
     * Gibt gerade aktiven Enum-Wert wider
     * @return EnumField
     */
    public EnumField getSingleSelection() {
        return SingleSelection;
    }

    /**
     * Setzt neuen aktiven Wert des Enums
     * @param singleSelection {@link EnumField} - neuer aktiver Wert
     */
    public void setSingleSelection(EnumField singleSelection) {
        SingleSelection = singleSelection;
    }

    /**
     * Gibt alle Werte des Enums wider
     * @return []
     */
    abstract public EnumField[] getEnumMappingList();

    /**
     * Gibt Feld dieser Abstraktion f&uuml;r allgemeines java Enum wider
     * @param E {@link Enum} - such-Enum
     * @return EnumField
     */
    public EnumField getFieldByDataEnum(Enum E) {
        for(EnumModel.EnumField Field : this.getEnumMappingList()) {
            if(Field.Item == E) {
                return Field;
            }
        }
        return null;
    }



}
