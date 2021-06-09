package ebd;

import de.disposim.dbd.io.SessionClosedException;
import de.disposim.dbd.packet.IllegalNameLengthException;
import de.ibw.tms.ma.physical.MoveableTrackElement;
import de.ibw.tms.ma.physical.TrackElementStatus;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.util.ThreadedRepo;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.verification.VerificationMode;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-11-25
 */
class TescModulTest {

    @Spy
    TescModul MUT = TescModul.getInstance();


    private void initTest() {
        PlanData.getInstance();

    }


    void checkDKW() throws IllegalNameLengthException, SessionClosedException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {
        initTest();
        new Thread() {

            @Override
            public void run() {
                TrackElementStatus stat = new TrackElementStatus();
                stat.statusList.add(TrackElementStatus.Status.LEFT);
                stat.statusList.add(TrackElementStatus.Status.LEFT);
                try {
                    TescModul.getInstance().setState("12W19",stat);
                } catch (IOException | SessionClosedException | IllegalNameLengthException e) {
                    e.printStackTrace();
                }
                while (true);
            }


        }.start();
        Thread.sleep(12000);

        Field privateField = TescModul.class.getDeclaredField("DkwStateByRepo");
        privateField.setAccessible(true);
        ThreadedRepo<String, MoveableTrackElement> dkwRep =
                (ThreadedRepo<String, MoveableTrackElement>) privateField.get(MUT);
        MoveableTrackElement MTE = dkwRep.getModel("12W19");
        TrackElementStatus TES = MTE.getCurrentStatus();
        assertEquals(TrackElementStatus.Status.LEFT, TES.statusList.get(0));
        assertEquals(TrackElementStatus.Status.LEFT, TES.statusList.get(1));
    }


    void checkDKWRR() throws IllegalNameLengthException, SessionClosedException, IOException, InterruptedException, NoSuchFieldException, IllegalAccessException {
        initTest();
        new Thread() {

            @Override
            public void run() {
                TrackElementStatus stat = new TrackElementStatus();
                stat.statusList.add(TrackElementStatus.Status.RIGHT);
                stat.statusList.add(TrackElementStatus.Status.RIGHT);
                try {
                    TescModul.getInstance().setState("12W19",stat);
                } catch (IOException | SessionClosedException | IllegalNameLengthException e) {
                    e.printStackTrace();
                }
                while (true);
            }


        }.start();
        Thread.sleep(12000);

        Field privateField = TescModul.class.getDeclaredField("DkwStateByRepo");
        privateField.setAccessible(true);
        ThreadedRepo<String, MoveableTrackElement> dkwRep =
                (ThreadedRepo<String, MoveableTrackElement>) privateField.get(MUT);
        MoveableTrackElement MTE = dkwRep.getModel("12W19");
        TrackElementStatus TES = MTE.getCurrentStatus();
        assertEquals(TrackElementStatus.Status.RIGHT, TES.statusList.get(0));
        assertEquals(TrackElementStatus.Status.RIGHT, TES.statusList.get(1));
    }

}