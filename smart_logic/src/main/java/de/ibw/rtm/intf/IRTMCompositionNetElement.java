package de.ibw.rtm.intf;
import org.railMl.rtm4rail.RTMOrderedCollection;
import org.railMl.rtm4rail.RTMUnorderedCollection;
import java.util.List;
public interface IRTMCompositionNetElement extends IRTMNetElement {
    List<RTMUnorderedCollection> getElementCollectionUnordered();
    List<RTMOrderedCollection> getElementCollectionOrdered();
}
