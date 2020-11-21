package de.ibw.tms.etcs;

public enum Q_SUITABILITY {
    LOADING_GAUGE(0), MAX_AXLE_LOAD(1), TRACTION_SYSTEM(2), SPARE(3);
    private final byte value;

    private Q_SUITABILITY(int i) {
        value = (byte) i;
    }

    public byte getValue() {
        return value;
    }
}
