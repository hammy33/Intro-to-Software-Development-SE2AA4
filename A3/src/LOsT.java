/**
 * Author: Hamrish Saravanakumar
 * Revised: March 29th 2021
 * Description: LOsT ADT Class that inherits Measures
 */

package src;

import src.AttributeT;
import src.IndicatorT;
import src.Services;
import src.Measures;

import java.util.Arrays;

public class LOsT implements Measures{

    private String name;
    private int n_blw;
    private int n_mrg;
    private int n_mts;
    private int n_exc;

    public LOsT(String name, int nblw, int nmrg, int nmts, int nexc) {
        if (nblw < 0 || nmrg < 0 || nmts < 0 || nexc < 0) {
            throw new IllegalArgumentException("IllegalArgumentException");
        }
        if (nblw == 0 && nmrg == 0 && nmts == 0 && nexc == 0) {
            throw new IllegalArgumentException("IllegalArgumentException");
        }
        else {
            this.name = name;
            this.n_blw = nblw;
            this.n_mrg = nmrg;
            this.n_mts = nmts;
            this.n_exc = nexc;
        }
    }

    public String getName() {
        return this.name;
    }

    public boolean equals(LOsT o) {
        return o.getName() == this.getName();
    }

    @Override
    public double[] measures() {
        double[] array = new double[4];
        array[0] = this.n_blw; 
        array[1] = this.n_mrg;
        array[2] = this.n_mts;
        array[3] = this.n_exc;

        if (Norm.getNLOs() == false) {
            return array;
        }
        else {
            return Services.normal(array);
        }
    }

    @Override
    public double[] measures(IndicatorT ind) {
        throw new UnsupportedOperationException("UnsupportedOperationException");
    }

    @Override
    public double[] measures(AttributeT att) {
        throw new UnsupportedOperationException("UnsupportedOperationException");
    }
    
}