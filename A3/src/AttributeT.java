/**
 * Author: Hamrish Saravanakumar
 * Revised: March 29th 2021
 * Description: AttributeT ADT Class
 */

package src;

import src.IndicatorT;
import java.util.HashSet;

public class AttributeT {
    private String name;
    private HashSet<IndicatorT> s;

    public AttributeT(String attribName, IndicatorT[] indicators){
        this.name = attribName;
        HashSet<IndicatorT> set = new HashSet<IndicatorT>();
        for (IndicatorT i : indicators) {
            set.add(i);
        }
        this.s = set;
    }

    public String getName(){
        return this.name;
    }

    public IndicatorT[] getIndicators(){
        IndicatorT[] indicators = new IndicatorT[this.s.size()];
        int i = 0;
        for(IndicatorT ind : this.s){
            indicators[i++] = ind;
        }
        return indicators;
    }
}