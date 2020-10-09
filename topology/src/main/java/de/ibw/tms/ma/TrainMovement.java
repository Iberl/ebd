package de.ibw.tms.ma;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import de.ibw.tms.etcs.ETCS_TrainData;

import java.io.Serializable;
@JsonIgnoreProperties(value = {
        "movementAuthority"
})
public class TrainMovement implements Serializable {
    MovementAuthority movementAuthority;
    @Expose
    private ETCS_TrainData trainData;
    // MANY TODO

}
