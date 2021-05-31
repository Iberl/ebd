package intf

import de.ibw.smart.logic.intf.impl.threads.TmsOuputWorker
import de.ibw.smart.logic.intf.messages.SmartServerMessage
import io.netty.channel.ChannelHandlerContext
import spock.lang.Shared
import spock.lang.Specification

import java.lang.reflect.AccessibleObject
import java.lang.reflect.Field
import java.lang.reflect.Modifier
import java.security.AccessController
import java.security.InvalidParameterException
import java.security.PrivilegedAction
import java.util.concurrent.SynchronousQueue


/**
 * @auther iberl@verkehr.tu-darmstadt.de
 * @version 1.0
 * @since 18.03.2021
 */
class TmsOutputWorkerSpec extends Specification {



    def "guard check null queue"() {
            given:
                def ctx = Mock(ChannelHandlerContext.class);
            when:
                def MUT = new TmsOuputWorker<Object>(null , ctx);
            then:
                thrown(InvalidParameterException);
    }
    def "guard check null context"() {
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

        SynchronousQueue<SmartServerMessage> spyQueue = Stub(SynchronousQueue<SmartServerMessage>);
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


    }

}
