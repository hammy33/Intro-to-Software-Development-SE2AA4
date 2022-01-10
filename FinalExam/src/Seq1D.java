package src;

import java.util.ArrayList;

public class Seq1D {
    
    private MeanCalculator meanCalculator;
    private ArrayList<Double> s;

    public Seq1D(ArrayList<Double> x, MeanCalculator m) {
        if (x.size() == 0) {
            throw new IllegalArgumentException("Empty sequence not allowed"); 
        }
        this.s = x;
        this.meanCalculator = m;
    }

    public void setMeanCalculator(MeanCalculator m) {
        meanCalculator = m;
    }

    public double mean() {
        return meanCalculator.meanCalc(s);
    }


}
