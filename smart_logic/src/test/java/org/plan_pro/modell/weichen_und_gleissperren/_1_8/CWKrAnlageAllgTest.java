package org.plan_pro.modell.weichen_und_gleissperren._1_8;

import de.ibw.tms.plan_pro.adapter.PlanProTmsAdapter;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CWKrAnlageAllgTest {

    @Test
    public void testImportFromExternal() throws JAXBException, ParseException {
      /*  ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("FrederiksBeispiel.xml");
        String text = "";
        try {
            BufferedReader Reader = new BufferedReader(new InputStreamReader(is));
            String line = "";
            while ((line = Reader.readLine()) != null) {
                text += line.length();
            }
        } catch (Exception E) {

        }*/
        JAXBContext jaxbContext = JAXBContext.newInstance(plan_pro.modell.planpro._1_9_0.ObjectFactory.class);

        //2. Use JAXBContext instance to create the Unmarshaller.
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        //3. Use the Unmarshaller to unmarshal the XML document to get an instance of JAXBElement.
        JAXBElement<plan_pro.modell.planpro._1_9_0.CPlanProSchnittstelle> unmarshalledObject =
                (JAXBElement<plan_pro.modell.planpro._1_9_0.CPlanProSchnittstelle>)unmarshaller.unmarshal(
                        ClassLoader.getSystemResourceAsStream("Test_11_03_20.ppxml"));

        //4. Get the instance of the required JAXB Root Class from the JAXBElement.
        plan_pro.modell.planpro._1_9_0.CPlanProSchnittstelle expenseObj = unmarshalledObject.getValue();
        System.out.println(expenseObj.getLSTZustand().getContainer().getGEOKante().size());
        assertTrue(expenseObj.getLSTZustand().getContainer().getGEOKante().size() > 0);

        PlanProTmsAdapter tmsAdapter = new PlanProTmsAdapter(PlanProTmsAdapter.PlanProVersion.V1_9_0_PATCHED, expenseObj);

    }


}