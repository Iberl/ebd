import de.ibw.tms.ma.Chainage;
import de.ibw.tms.ma.physical.TrackElementStatus;
import de.ibw.tms.ma.topologie.ApplicationDirection;
import de.ibw.tms.ma.net.elements.PositionedRelation;

import java.security.InvalidParameterException;
import java.util.Random;

public class TestUitlities {

    public enum ChainageSteps {
        TenMeterSteps,
        HundredMeterSteps,
        ThousendMeterSteps,
    }
    public static Chainage LastChainage;

    public class Int_Handler {
        Integer iV = null;
        Int_Handler(Integer intV, boolean bIsRandom, int iMax, int iMin) {
            if(bIsRandom) {
               this.iV = new Random().nextInt(iMax - iMin) + iMin;
            } else {
                if (intV == null) {
                    throw new InvalidParameterException("v may not be null, when no random.");
                } else{
                    this.iV = intV;
                }
            }

        }

    }



    public static PositionedRelation generateJunkRandomPositionedRelation() {
        return null;
    }






}
