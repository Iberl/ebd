package de.ibw.tms.ma;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;


public class RbcMA extends MovementAuthority implements Serializable {
    public static final long serialVersionUID = 773L;

    // für Christopher.... bitte zeitnah schicken...
    public RbcMA(String sTrainId) {
        this.sTrainId = sTrainId;


    }

    public String sTrainId;

    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        //mapper.enable(SerializationFeature.INDENT_OUTPUT);


        return mapper.writeValueAsString(this);
    }



}
