package de.ibw.tms.trackplan.viewmodel;

import de.ibw.tms.ma.physical.TrackElement;
import de.ibw.tms.ma.topologie.PositionedRelation;

public class Graph {
    public class Node extends TrackElement {

        public Node(TrackElement TE) {
            this.TE = TE;
        }

        private TrackElement TE;

        @Override
        public String getViewName() {
            return TE.getViewName();
        }
    }

    public class Edge extends PositionedRelation {

    }


}
