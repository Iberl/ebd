package de.ibw.tms.intf;

import com.google.gson.annotations.Expose;
import de.ibw.tms.intf.cmd.CheckMovementAuthority;
import de.ibw.tms.intf.cmd.Commands;


    public class TmsMovementAuthority extends TmsMessage implements Comparable<TmsMessage> {

        @Expose
        public CheckMovementAuthority payload;

        public TmsMovementAuthority(String tms_id, String rbc_id, CheckMovementAuthority payload) {
            super(tms_id, rbc_id,payload);
            this.payload = payload;
        }

        @Override
        public String toString() {
            return "TmsMovementAuthority{" +
                    "payload=" + payload +
                    ", type=" + type +
                    ", tms_id='" + tms_id + '\'' +
                    ", rbc_id='" + rbc_id + '\'' +
                    '}';
        }

        @Override
        public int compareTo(TmsMessage otherMessage) {
            return this.payload.lPriority.compareTo(otherMessage.getPayload().lPriority);
        }

        @Override
        public Commands getPayload() {
            return this.payload;
        }
    }



