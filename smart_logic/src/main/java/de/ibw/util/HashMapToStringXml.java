package de.ibw.util;

import de.ibw.tms.plan.elements.model.PlanData;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HashMapToStringXml {
    public static void main(String[] args) {
        PlanData.getInstance();

        String edgesToString = objectToString(PlanData.topGraph.edgeRepo);
        //System.out.println("Map to XML: \n" + edgesToString);

            //JAXBContext jc = JAXBContext.newInstance(HashMap.class);


        Map<Object, Object> hashMap = new HashMap<Object, Object>();
        hashMap.put("firstName", "Pritom");
        hashMap.put("lastName", hashMap);

        Map<Object, Object> secondMap = new HashMap<Object, Object>();
        secondMap.put("timeIn", "8:00");
        secondMap.put("timeOut", "5:00");
        hashMap.put("timing", secondMap);

        List<Object> list = new ArrayList<Object>();
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(secondMap);
        hashMap.put("contents", list);


        String mapToString = objectToString(hashMap);
        Map parsedMap = (Map) stringToObject(mapToString);
        System.out.println("Map to XML: \n" + mapToString + "\nXML to map:\n" + parsedMap);

        /* List to XML and reverse */
        String listToString = objectToString(list);
        List parsedList = (List) stringToObject(listToString);
        System.out.println("List to XML: \n" + listToString + "\nXML to list:\n" + parsedList);
    }

    public static String objectToString(Object hashMap) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        XMLEncoder xmlEncoder = new XMLEncoder(bos);
        xmlEncoder.writeObject(hashMap);
        xmlEncoder.close();
        return bos.toString();
    }

    public static Object stringToObject(String string) {
        XMLDecoder xmlDecoder = new XMLDecoder(new ByteArrayInputStream(string.getBytes()));
        return xmlDecoder.readObject();
    }
}