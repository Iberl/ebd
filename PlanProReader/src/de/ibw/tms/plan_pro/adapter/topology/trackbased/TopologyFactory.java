package de.ibw.tms.plan_pro.adapter.topology.trackbased;

import plan_pro.modell.balisentechnik_etcs._1_9_0.CDatenpunkt;
import plan_pro.modell.basisobjekte._1_9_0.CBasisObjekt;
import plan_pro.modell.geodaten._1_9_0.*;
import plan_pro.modell.planpro._1_9_0.CPlanProSchnittstelle;
import plan_pro.modell.signale._1_9_0.CSignal;
import plan_pro.modell.weichen_und_gleissperren._1_9_0.CWKrAnlage;
import plan_pro.modell.weichen_und_gleissperren._1_9_0.CWKrGspElement;
import plan_pro.modell.weichen_und_gleissperren._1_9_0.CWKrGspKomponente;
import jakarta.xml.bind.*;

import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Diese Klasse dient zur Erzeugung eines Topologieschen Graphen
 * @author Werner Iberl <iberl@verkher.tu-darmstadt.de />
 * @since 2021-04-27
 * @version 0.5
 */
public class TopologyFactory {


    private static final boolean B_PRINT_BALISE_LIST = true;
    /**
     * Dieses Feld gibt an, ob der erzeugte Graph in PlanData gespeichert werden soll
     */
    public static boolean shallAssignToActivePlanData = true;


    private List<CTOPKante> topLines; // input


    private Class[] aPlattformKeys;
    private Class[] aCrossingKeys;
    private Class[] aSpeedKeys;




    private CPlanProSchnittstelle PlanProDefinition;

    public CPlanProSchnittstelle getcPlanProSchnittstelle(InputStream planProInput) throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance(plan_pro.modell.planpro._1_9_0.ObjectFactory.class);

        //2. Use JAXBContext instance to create the Unmarshaller.
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        ClassLoader classLoader = MethodHandles.lookup().getClass().getClassLoader();


        //3. Use the Unmarshaller to unmarshal the XML document to get an instance of JAXBElement.
        JAXBElement<CPlanProSchnittstelle> unmarshalledObject =
                (JAXBElement<CPlanProSchnittstelle>)unmarshaller.unmarshal(
                        planProInput);
        //4. Get the instance of the required JAXB Root Class from the JAXBElement.
        return unmarshalledObject.getValue();

    }
}
