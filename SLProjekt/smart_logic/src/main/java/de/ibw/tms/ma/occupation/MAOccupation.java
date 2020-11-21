package de.ibw.tms.ma.occupation;
/**
 * Ein von einer MA belegter Abschnitt
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-10-30
 */
public class MAOccupation extends Occupation {
    public static final String CLASS_IDENTIFIER = "MA_Occupation";
    public MAOccupation() {
        super(CLASS_IDENTIFIER);
    }

}
