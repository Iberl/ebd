package de.ibw.tms.etcs;

public enum M_MAMODE {
    ON_SIGHT(0),SHUNTING(1),LIMITED_SUPERVISION(2),SPARE(3);
    private final byte value;


    private M_MAMODE(int i) {
        value = (byte) i;
    }

    public byte getValue() {
        return value;
    }
}
