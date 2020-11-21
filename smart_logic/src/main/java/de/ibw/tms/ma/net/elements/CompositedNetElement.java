package de.ibw.tms.ma.net.elements;

import de.ibw.rtm.intf.IRTMCompositionNetElement;
import org.railMl.rtm4rail.RTMOrderedCollection;
import org.railMl.rtm4rail.RTMUnorderedCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * Ein zusammengesetztes Strukturelles Netzelement
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-10-12
 */
public abstract class CompositedNetElement extends NetElement implements IRTMCompositionNetElement {

   public CompositedNetElement(String sName) {
       super(sName);
   }

    @Override
    public List<RTMUnorderedCollection> getElementCollectionUnordered() {
        return new ArrayList<>();
    }

    @Override
    public List<RTMOrderedCollection> getElementCollectionOrdered() {
        return new ArrayList<>();
    }
}
