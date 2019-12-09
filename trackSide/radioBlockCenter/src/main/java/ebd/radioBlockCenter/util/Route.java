package ebd.radioBlockCenter.util;

public class Route {

    private String id;
    private double distance;
    private int[] tsp;
    private int[] gp;


    public Route(String id, double distance, int[] tsp, int[] gp) {
        this.id = id;
        this.distance = distance;
        this.tsp = tsp;
        this.gp = gp;
    }

    public String getId() {
        return id;
    }

    /**
     * @return [m]
     */
    public double getDistance() {
        return distance;
    }

    /**
     * @return [m,km/h]
     */
    public int[] getTsp() {
        return tsp;
    }

    /**
     * @return [m,0/00]
     */
    public int[] getGp() {
        return gp;
    }
}
