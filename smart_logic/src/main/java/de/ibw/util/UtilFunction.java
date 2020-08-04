package de.ibw.util;

import de.ibw.tms.ma.GeoCoordinates;

public class UtilFunction {
    public static int formatStringToInt(String sInputSpeed) throws NumberFormatException {
        String[] arr = sInputSpeed.split(" ", 2);

        String firstWord = arr[0];
        int iInitialSpeed;
        try {
            iInitialSpeed = Integer.parseInt(firstWord);
        } catch(NumberFormatException e) {
            throw e;

        }
        return iInitialSpeed;
    }
    public static ICoord<Double> calcTargetGeoByStartPoint(ICoord<Double> CalcTarget, double dA, GeoCoordinates geo_A, GeoCoordinates geo_B) {
        double dx_diff = geo_B.getX() - geo_A.getX();
        if(dx_diff == 0d) {
            double dYnew = geo_A.getY() + dA;
            CalcTarget.setX(geo_B.getX());
            CalcTarget.setY(dYnew);
        } else {

            double dYdiff = geo_B.getY() - geo_A.getY();

            double radians = Math.atan(dYdiff/dx_diff);
            double xAdd = Math.cos(radians) * dA;
            double yAdd = Math.sin(radians) * dA;
            CalcTarget.setX(geo_A.getX() + xAdd);
            CalcTarget.setY(geo_A.getY() + yAdd);
            //B.setX(Geo_A.getX());
            //B.setY(Geo_A.getY());

        }
        return CalcTarget;
    }
}