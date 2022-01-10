/**
 * @author: Hamrish Saravanakumar
 * @date: March 29th 2021
 * @brief: CourseT ADT Class that inherits Measures
 */

package src;

import src.AttributeT;
import src.IndicatorT;
import src.Services;
import src.Measures;
import src.Norm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @brief An ADT that represents a Course
 * @details CourseT is not used until indicators are populated with learning outcomes
 */
public class CourseT implements Measures{

    private String name;
    private HashMap<IndicatorT, HashSet<LOsT>> m;

    /**
     * @brief Initializes a CourseT object
     * @param courseName String that represents name of the course
     * @param indicators List of indicators 
     * @details Starts with the set of learning outcomes being empty
     */
    public CourseT(String courseName, IndicatorT[] indicators){
        this.name = courseName;
        HashMap<IndicatorT, HashSet<LOsT>> map = new HashMap<IndicatorT, HashSet<LOsT>>();
        for(int i = 0; i < indicators.length; i++) {
            map.put(indicators[i], new HashSet<LOsT>());
        }
        this.m = map;
    }
    
    /**
    * @brief Getter method for the course name
    * @returns The name of the course
    */
    public String getName(){
        return this.name;
    }

    /**
    * @brief Getter method for the list of indicators
    * @returns The list of indicators 
    */
    public IndicatorT[] getIndicators() {
        IndicatorT[] indicators = new IndicatorT[this.m.size()];
        int count = 0;
        for (IndicatorT ind : this.m.keySet()) {
            indicators[count++] = ind;
        }
        return indicators;
    }

    /**
    * @brief Getter method for the learning outcomes
    * @param indicator The indicator for which the learning outcomes should be returned for
    * @returns The list of learning outcomes, or an empty list if the indicator is not in this.m
    */
    public LOsT[] getLOs(IndicatorT indicator) {
        for (IndicatorT i : this.m.keySet()) {
            if (i.equals(indicator)) {
                return set_to_seq(this.m.get(i));
            }
        }
        return new LOsT[0];
    }
    
    /**
    * @brief Method to add a Learning outcome for an indicator if it is in this.m
    * @param indicator The indicator for which the learning outcomes should be added to
    * @param outcome The outcome to be added 
    */
    public void addLO(IndicatorT indicator, LOsT outcome) {
        for (IndicatorT i : this.m.keySet()) {
            if (i.equals(indicator)) {
                if(this.m.get(i).contains(outcome) == false) {
                    this.m.get(i).add(outcome);
                }
            }
        }
    }

    /**
    * @brief Method to add a Learning outcome for an indicator if it is in this.m
    * @param indicator The indicator for which the learning outcomes should be deleted from
    * @param outcome The outcome to be deleted 
    */
    public void delLO(IndicatorT indicator, LOsT outcome) {
        for (IndicatorT i : this.m.keySet()) {
            if (i.equals(indicator)) {
                if(this.m.get(i).contains(outcome) == true) {
                    this.m.get(i).remove(outcome);
                }
            }
        }
    }

    /**
    * @brief Method to add a Learning outcome for an indicator if it is in this.m
    * @param indicator The indicator for which the learning outcomes should be compared to
    * @param outcomes List of learning outcomes to be compared to the learning outcomes specific to the parameter indicator
    * @returns true is returned if the input list of learning outcomes is equal to the outcomes specific to the input indicator, and false otherwise
    */
    public boolean member(IndicatorT indicator, LOsT[] outcomes) {
        for (IndicatorT i : this.m.keySet()) {
            if (i.equals(indicator)) {
                for (int j = 0; j < outcomes.length; j++) {
                    if (this.m.get(indicator).contains(outcomes[j]) != true) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
    * @brief Method to overwrite the measures function with no input 
    * @throws UnsupportedOperationException The operation isn't unsupported for CourseT if there is no parameter and should thus throw an exception
    */
    @Override
    public double[] measures() {
        throw new UnsupportedOperationException("UnsupportedOperationException");
    }

    /**
    * @brief Method to overwrite the measures function when an indicator is passed as input 
    * @param indicator The indicator used to return that particular indicator measures sequence
    * @returns The appropriate measures indicator sequence
    */
    @Override
    public double[] measures(IndicatorT ind) {
        if (this.getLOs(ind).length == 0) {
            return new double[]{0, 0, 0, 0};
        }
        else {
            double[] measureInd = new double[4];
            if(Norm.getNInd()) {
                double[] seq1 = new double[]{0, 0, 0, 0};
                for (int i = 0; i < this.getLOs(ind).length; i++) {
                    double[] seq2 = this.getLOs(ind)[i].measures();
                    measureInd = sumMeas(seq1, seq2);
                    seq1 = measureInd;
                }
                return Services.normal(measureInd);
            }
            else {
                double[] seq1 = new double[]{0, 0, 0, 0};
                for (int i = 0; i < this.getLOs(ind).length; i++) {
                    double[] seq2 = this.getLOs(ind)[i].measures();
                    measureInd = sumMeas(seq1, seq2);
                    seq1 = measureInd;
                }
                return measureInd;
            }
        }
    }

    /**
    * @brief Method to overwrite the measures function when an indicator is passed as input 
    * @param att The indicator used to return that particular indicator measures sequence
    * @returns The appropriate measures indicator sequence
    */
    @Override
    public double[] measures(AttributeT att) {
        if (att.getIndicators().length == 0) {
            return new double[]{0, 0, 0, 0};
        }
        else {
            double[] measureInd = new double[4];
            if(Norm.getNAtt()) {
                double[] seq1 = new double[]{0, 0, 0, 0};
                for (int i = 0; i < att.getIndicators().length; i++) {
                    double[] seq2 = this.measures(att.getIndicators()[i]);
                    measureInd = sumMeas(seq1, seq2);
                    seq1 = measureInd;
                }
                return Services.normal(measureInd);
            }
            else {
                double[] seq1 = new double[]{0, 0, 0, 0};
                for (int i = 0; i < att.getIndicators().length; i++) {
                    double[] seq2 = this.measures(att.getIndicators()[i]);
                    measureInd = sumMeas(seq1, seq2);
                    seq1 = measureInd;
                }
                return measureInd;
            }
        }
    }

    private LOsT[] set_to_seq(HashSet<LOsT> LOsT_set) {
        LOsT[] LOsT_sequence = new LOsT[LOsT_set.size()];
        int i=0;
        for(LOsT ele:LOsT_set){
          LOsT_sequence[i++] = ele;
        }
        return LOsT_sequence;
    }

    private double[] sumMeas(double[] seq1, double[] seq2) {
        double[] seq = new double[4];
        for (int i = 0; i < seq1.length; i++) {
            seq[i] = seq1[i] + seq2[i];
        }
        return seq;
    }
}
