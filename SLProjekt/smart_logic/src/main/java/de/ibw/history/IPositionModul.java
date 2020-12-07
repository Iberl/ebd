package de.ibw.history;


import de.ibw.history.data.PositionEnterType;

import java.math.BigDecimal;
import java.util.Collection;

/**
 *
 * Interface zur Abfrage von Positionsdaten
 * @author iberl@verkehr.tu-darmstadt.de
 *
 * @version 0.4
 * @since 2020-09-30
 */
public interface IPositionModul {

    Collection<PositionData> getCurrentPositions();
    PositionData getCurrentPosition(int iNidEngine);


    Collection<PositionData> getCurrentPositions(Integer iNidEngine, String sIdTopEdge, BigDecimal dFromRangeStart, BigDecimal dToRangeEnd);


    Collection<PositionData> getAllPositions();
    Collection<PositionData> getAllPositions(int iNidEngine);

    Collection<PositionData> getAllPositions(Integer iNidEngine, String sIdTopEdge, BigDecimal dFromRangeStart, BigDecimal dToRangeEnd);

    void addPositionData(PositionData PD, PositionEnterType EnterType);

    void setTimeFilter(boolean bIsRbc, long lFrom, long lTo);
    void resetTimeFilter();


}
