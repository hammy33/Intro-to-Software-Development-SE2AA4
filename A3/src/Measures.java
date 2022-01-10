/**
 * Author: Hamrish Saravanakumar
 * Revised: March 29th 2021
 * Description: Measures Interface Modules
 */

 package src;

import src.AttributeT;
import src.IndicatorT;

public interface Measures{
    public double[] measures() throws UnsupportedOperationException;
    public double[] measures(IndicatorT ind) throws UnsupportedOperationException;
    public double[] measures(AttributeT att) throws UnsupportedOperationException;
}
