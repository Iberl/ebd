package de.ibw.smart.logic.intf;

import ebd.rbc_tms.Message;

import java.security.InvalidParameterException;

public class PriorityMessage implements Comparable<PriorityMessage> {
    private Message Msg;
    // min is first
    private Long iPriority = 100L;

    public Message getMsg() {
        return Msg;
    }

    public PriorityMessage(Message M, Long iPriority) {
        if(iPriority == null || M == null) throw new InvalidParameterException("Paramters must not be null");
        iPriority = iPriority;
        Msg = M;
    }

    public Long getiPriority() {
        return iPriority;
    }

    public void setiPriority(Long iPriority) {
        this.iPriority = iPriority;
    }


    @Override
    public int compareTo(PriorityMessage priorityMessage) {
        return this.iPriority.compareTo(priorityMessage.iPriority);
    }
}
