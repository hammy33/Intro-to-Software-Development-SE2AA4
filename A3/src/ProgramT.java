/**
 * Author: Hamrish Saravanakumar
 * Revised: March 29th 2021
 * Description: ProgramT ADT Class that inherits Measures and HashSet(CourseT)
 */


package src;

import java.util.HashSet;

import src.AttributeT;
import src.IndicatorT;
import src.Services;
import src.Measures;
import src.Norm;
import src.CourseT;

public class ProgramT extends HashSet<CourseT> implements Measures{

    private HashSet<CourseT> s = this;

    public double[] measures() {
        throw new UnsupportedOperationException("UnsupportedOperationException");
    }

    public double[] measures(IndicatorT ind) {
        throw new UnsupportedOperationException("UnsupportedOperationException");
    }

    public double[] measures(AttributeT att) throws UnsupportedOperationException {
        CourseT[] courses = new CourseT[this.s.size()];
        int count = 0;
        for (CourseT course : s) {
            courses[count++] = course;
        }
        double[] measures = new double[4];
        double[] seq1 = new double[]{0, 0, 0, 0};
        for (int i = 0; i < courses.length; i++) {
            double[] seq2 = courses[i].measures(att);
            measures = sumMeas(seq1, seq2);
            seq1 = measures;
        }
        return Services.normal(measures);
    }

    private double[] sumMeas(double[] seq1, double[] seq2) {
        double[] seq = new double[4];
        for (int i = 0; i < seq1.length; i++) {
            seq[i] = seq1[i] + seq2[i];
        }
        return seq;
    }


}
