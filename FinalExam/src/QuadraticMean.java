package src;

import java.util.ArrayList;
import java.lang.Math;

public class QuadraticMean implements MeanCalculator {
    public double meanCalc(ArrayList<Double> v) {
        double sum = 0;
        for (int x = 0; x < v.size(); x++) {
            sum = sum + Math.pow(v.get(x), 2);
        }
        return Math.sqrt(sum/v.size());
    }
}