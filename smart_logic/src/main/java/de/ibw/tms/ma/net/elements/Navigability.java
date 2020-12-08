package de.ibw.tms.ma.net.elements;

/**
 * Navigierbarkeit von "PositionedRlation"
 * Es kann von Element A nach Element B gefahren werden : AB
 * Es kann von Element B nach Element A gefahren werden : BA
 * Es kann von A nach B und gleichzeitig von B nach A gefahren werden : Both
 * Man kann weder von A nach B fahren noch von B nach A : None
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-10-12
 */
public enum Navigability {
    AB, BA, BOTH, NONE
}
