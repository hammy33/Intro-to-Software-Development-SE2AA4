/**
 * Author: Hamrish Saravanakumar
 * Revised: March 29th 2021
 * Description: Norm Abstract Object Module
 */

package src;

public class Norm {
    private static boolean normLOs;
    private static boolean normInd;
    private static boolean normAtt;

    public static void setNorms(boolean nLOs, boolean nInd, boolean nAtt) {
        normLOs = nLOs;
        normInd = nInd;
        normAtt = nAtt;
    }
    public static boolean getNLOs() {
        return normLOs;
    }
    public static boolean getNInd() {
        return normInd;
    }
    public static boolean getNAtt() {
        return normAtt;
    }
    public static void setNLOs(boolean nLOs) {
        normLOs = nLOs;
    }
    public static void setNInd(boolean nInd) {
        normInd = nInd;
    }
    public static void getNAtt(boolean nAtt) {
        normAtt = nAtt;
    }

}
