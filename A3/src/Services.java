/**
 * Author: Hamrish Saravanakumar
 * Revised: March 29th 2021
 * Description: Services Library Module
 */

package src;

public class Services {

    public static double[] normal(double[] v) {
        double[] sequence = new double[v.length];
        for(int i = 0; i < sequence.length; i++) {
            sequence[i] = v[i] / sum(v);
        }
        return sequence;
            
    }

    private static double sum(double[] sequence) {
        double sum = 0;
        for(int i = 0; i < sequence.length; i++) {
            sum = sum + sequence[i];
        }
        return sum;
    }
}
