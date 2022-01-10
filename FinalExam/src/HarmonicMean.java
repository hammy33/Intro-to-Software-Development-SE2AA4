package src;

import java.util.ArrayList;

public class HarmonicMean implements MeanCalculator {
    public double meanCalc(ArrayList<Double> v) {
        double sum = 0;
        for (int x = 0; x < v.size(); x++) {
            sum = sum + (1/v.get(x));
          }
        return v.size()/sum;
    }
}