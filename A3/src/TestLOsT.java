/**
 * Author: Hamrish Saravanakumar
 * Revised: March 29 2021
 * 
 * Description: Tester File for LOsT  
 */

package src;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.Arrays;

public class TestLOsT
{

    private AttributeT ProbSolving;
    private AttributeT Design;
    private LOsT LO1;
    private LOsT LO2;
    private LOsT LO3;

    @Before
    public void setUp() {
        ProbSolving = new AttributeT("Problem Solving", new IndicatorT[] {IndicatorT.recogTheory, IndicatorT.modelSelect,
                                                                                        IndicatorT.estOutcomes});

        Design = new AttributeT("Design", new IndicatorT[] {IndicatorT.desProcess, IndicatorT.desPrinciples,
                                                                        IndicatorT.openEnded, IndicatorT.ideaGeneration,
                                                                        IndicatorT.healthSafety, IndicatorT.standards});

        LO1 = new LOsT("outcome 1", 23, 46, 56, 75);
        LO2 = new LOsT("outcome 1", 15, 6, 78, 4);
        LO3 = new LOsT("outcome 3", 15, 6, 78, 4);

    }

    @After
    public void tearDown() {
        ProbSolving = null;
        Design = null;
        LO1 = null;
        LO2 = null;
        LO3 = null;
    }

    @Test (expected=IllegalArgumentException.class)
    public void testNegativeMeasure() {
        LOsT LOs = new LOsT("topic", -15, 22, 7, 21);
    }

    @Test (expected=IllegalArgumentException.class)
    public void testZeroMeasures() {
        LOsT LOs = new LOsT("topic", 0, 0, 0, 0);
    }

    @Test
    public void testgetName1()
    {
        assertEquals(LO1.getName(), "outcome 1");
    }

    @Test
    public void testgetName2()
    {
        assertNotSame(LO2.getName(), "outcome2");
    }

    @Test
    public void testequals1()
    {
        assertTrue(LO1.equals(LO2));
    }


    @Test
    public void testequals2()
    {
        assertFalse(LO2.equals(LO3));
    }

    @Test 
    public void testmeasures1() {
        Norm.setNorms(false, false, false);
        assertTrue(Arrays.equals(LO1.measures(), new double[]{23.0, 46.0, 56.0, 75.0}));
    }

    @Test 
    public void testmeasures2() {
        Norm.setNorms(true, false, true);
        assertTrue(Arrays.equals(LO1.measures(), new double[]{0.115, 0.23, 0.28, 0.375}));
    }

    @Test (expected=UnsupportedOperationException.class)
    public void testmeasuresInd() {
        LO1.measures(IndicatorT.desPrinciples);
    }

    @Test (expected=UnsupportedOperationException.class)
    public void testmeasuresAtt() {
        LO1.measures(Design);
    }
}
