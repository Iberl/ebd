package ebd.radioBlockCenter.util;

public class Route {

    private String id;
    private double distance;

    public Route(String id, double distance) {
        this.id = id;
        this.distance = distance;
    }

    public String getId() {
        return id;
    }

    public double getDistance() {
        return distance;
    }
}
