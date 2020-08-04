package de.ibw.tms.train.model;

public class TrainDistance {
    private boolean b_fromA;
    private double dDistance1;
    private double dDistance2;

    public TrainDistance(boolean isA, double d1, double d2) {
        this.b_fromA = isA;
        this.dDistance1 = d1;
        this.dDistance2 = d2;

    }

    public boolean isB_fromA() {
        return b_fromA;
    }

    public double getdDistance1() {
        return dDistance1;
    }

    public double getdDistance2() {
        return dDistance2;
    }
}
