package intf

import data.MovementPermissionRequestProvider
import de.ibw.history.TrackAndOccupationManager
import de.ibw.smart.logic.intf.SmartLogic
import de.ibw.smart.logic.intf.SmartServer
import de.ibw.smart.logic.intf.impl.SmartServer4TmsImpl
import de.ibw.smart.logic.intf.impl.threads.TmsOuputWorker
import de.ibw.smart.logic.intf.messages.SmartServerMessage
import de.ibw.smart.logic.safety.SafetyLogic
import de.ibw.tms.intf.TmsMovementPermissionRequest
import de.ibw.tms.intf.cmd.CheckMovementPermission
import de.ibw.tms.ma.EoaAdapter
import de.ibw.tms.ma.GradientProfileAdapter
import de.ibw.tms.ma.LinkingProfileAdapter
import de.ibw.tms.ma.ModeAdapter
import de.ibw.tms.ma.RbcMA
import de.ibw.tms.ma.RbcMaAdapter
import de.ibw.tms.ma.Route
import de.ibw.tms.ma.SpeedProfileAdapter
import de.ibw.tms.ma.SpeedSegment
import de.ibw.tms.ma.dynamic.RouteSection
import de.ibw.tms.ma.mob.MovableObject
import de.ibw.tms.ma.mob.common.NID_ENGINE
import de.ibw.tms.ma.mob.position.MOBPosition
import de.ibw.tms.ma.mob.position.SafeMOBPosition
import de.ibw.tms.ma.occupation.MAOccupation
import ebd.rbc_tms.util.EOA
import ebd.rbc_tms.util.GradientProfile
import ebd.rbc_tms.util.LinkingProfile
import ebd.rbc_tms.util.MA
import ebd.rbc_tms.util.ModeProfile
import ebd.rbc_tms.util.SpeedProfile
import io.netty.channel.ChannelHandlerContext

import spock.lang.Shared
import spock.lang.Specification

import java.security.InvalidParameterException
import java.util.concurrent.SynchronousQueue

/**
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 1.0
 * @since 18.03.2021
 *
 * Diese Klasse muss aktualisiert werden oder zur not loeschen
 */
class SmartServer4TmsImplSpec extends Specification {




    def "start smart server"() {
        System.out.println("Setup done");

    }

    private RbcMaAdapter getValidMa() {
        ArrayList<EOA.Section> secList = new ArrayList<>();
        secList.add(new EOA.Section(1,true,1,1))
        EOA eoa = new EOA(1,1,1,1, secList, new EOA.EndTimer(1,1), new EOA.DangerPoint(1,1),
            new EOA.Overlap(1,1,1,1)
        );
        List<GradientProfile.Gradient> gradients = new ArrayList<>();
        gradients.add(new GradientProfile.Gradient(1,true, 1));
        GradientProfile GP = new GradientProfile(1,1, gradients)
        List<SpeedProfile.Section> speedList = new ArrayList<>();
        SpeedProfile.Section.Category C = new SpeedProfile.Section.Category(1,1,1,1);
        ArrayList<SpeedProfile.Section.Category> categories = new ArrayList<>();
        categories.add(C);
        speedList.add(new SpeedProfile.Section(1,1,true, categories));
        SpeedProfile SP = new SpeedProfile(1,1, speedList );
        ModeProfile ModeP = new ModeProfile(1,1);
        LinkingProfile LP = new LinkingProfile(1,1);
        MA ma = new MA(true, 1, 1, 1, new EoaAdapter(eoa),
                GP, SP,  ModeP, LP );
        return new RbcMaAdapter(ma);

    }

    private RbcMA getNullEoa() {
        RbcMA result = new RbcMA("1");

    }



    def "checkMovementAuthority"() {
        given:
        SmartServer ServerMock = Spy(new SmartServer(null, 33330));
        SmartServer4TmsImpl MUT = Spy(SmartServer4TmsImpl.instance);
        TmsMovementPermissionRequest Request = new MovementPermissionRequestProvider().getTestRequest();
        CheckMovementPermission CMA = Request.getPayload();
        MovableObject MO = new MovableObject(new NID_ENGINE(1), new MOBPosition(new SafeMOBPosition()));
        new Thread() {
            @Override
            void run() {
                MUT.checkMovementAuthority(CMA.iTrainId, CMA.route, CMA.MaAdapter, CMA.uuid, CMA.tms_id, CMA.rbc_id,
                        CMA.lPriority);

            }
        }.start()



        expect:
        Thread.sleep(3000);
        SmartServer4TmsImpl.ackQueues.offer(Request.header.uuid, true);

        SmartServer4TmsImpl.instance != null;
        TrackAndOccupationManager.getReadOnly(MAOccupation.class, MO).getAll().iterator().next().size() == 1

    }


    /*
     * @deprecated
     * @return
     *
    def "guardMACheck"() {
        given:
            Route InvalidRoute = new Route(null);
            Route ValidRoute = new Route(new ArrayList<RouteSection>());
            ArrayList<RbcMA> invalidMa = new ArrayList<>();

            SmartServer4TmsImpl MUT = ServerMock.getSmartTms();

            /*invalidMa.add(getNullEoa());
            invalidMa.add(getNullEoaSections());
            invalidMa.add(getNullEoaQScale());
            invalidMa.add(getNullSpeedProfile());
            invalidMa.add(getNullSpeedSections());
            invalidMa.add(getWithEmptySpeedSections());
            invalidMa.add(getGradientProfileNull());
            invalidMa.add(getGradientsNull());
            invalidMa.add(getEmptyGradients());


        when:
            MUT.checkMovementAuthority(1, ValidRoute, getValidMa() as MA, UUID.randomUUID(), "1", "1", 1L);
        then:
            1 * MUT.guardMACheck();
            1 * SafetyLogic.getSmartSafety()



    }
    */

    /*def "guard check null context"() {
        given:
        def queue = new SynchronousQueue<Object>()
        when:
        def MUT = new TmsOuputWorker<Object>(queue , null);
        then:
            thrown(InvalidParameterException);
    }



    def "checkTransmissionSlToTMS"() {
        given:
        SynchronousQueue<SmartServerMessage> queue = new SynchronousQueue<SmartServerMessage>();
        SmartServerMessage SmartMessage = new SmartServerMessage("Test Transmission", 1L);
        SynchronousQueue<SmartServerMessage> spyQueue = Spy(queue);
        spyQueue.take() >>> [null, SmartMessage as SmartServerMessage] >> { throw new InterruptedException() }
        spyQueue.isEmpty() >> false
        spyQueue.size() >> 1
        Thread offerThread = new Thread() {
            @Override
            void run() {
                queue.offer(null)
                queue.offer(SmartMessage);
                queue.offer(SmartMessage);

            }
        }



        ChannelHandlerContext ctx2 = Mock(ChannelHandlerContext.class);
        TmsOuputWorker.SmartToTmsWorker = new TmsOuputWorker<SmartServerMessage>(spyQueue, ctx2);
        offerThread.start();

        when:
            TmsOuputWorker.SmartToTmsWorker.run();




        then:

        1 * ctx2.write(SmartMessage)
        1 * ctx2.flush()


    }*/

}
