/**
 * Author: Hamrish Saravanakumar
 * Revised: March 29 2021
 * 
 * Description: Tester File for CourseT  
 */

package src;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.Arrays;

public class TestCourseT
{

	private AttributeT ProbSolving;
    private AttributeT Design;
    private LOsT LO1;
    private LOsT LO2;
    private LOsT LO3;
    private LOsT LO4;
    private LOsT LO5;
    private IndicatorT[] SE2AA4_indicators;
    private CourseT SE2AA4;

    @Before
    public void setUp() {

		SE2AA4_indicators = new IndicatorT[] {IndicatorT.math, IndicatorT.specEngKnow, IndicatorT.assumpt,
		                                     IndicatorT.suitableFund, IndicatorT.recogTheory, IndicatorT.modelSelect,
		                                     IndicatorT.estOutcomes, IndicatorT.desProcess, IndicatorT.desPrinciples,
		                                     IndicatorT.openEnded};

        ProbSolving = new AttributeT("Problem Solving", new IndicatorT[] {IndicatorT.recogTheory, IndicatorT.modelSelect,
                                                                                        IndicatorT.estOutcomes});

        Design = new AttributeT("Design", new IndicatorT[] {IndicatorT.desProcess, IndicatorT.desPrinciples,
                                                                        IndicatorT.openEnded, IndicatorT.ideaGeneration,
                                                                        IndicatorT.healthSafety, IndicatorT.standards});

        SE2AA4 = new CourseT("Software Design I", SE2AA4_indicators);

        LO1 = new LOsT("outcome 1", 23, 46, 56, 75);
        LO2 = new LOsT("outcome 2", 5, 16, 28, 14);
        LO3 = new LOsT("outcome 3", 15, 6, 78, 4);
        LO4 = new LOsT("outcome 4", 1, 2, 0, 11);
        LO5 = new LOsT("outcome 5", 9, 12, 48, 12);

    }

    @After
    public void tearDown() {
    	SE2AA4_indicators = null;
        ProbSolving = null;
        Design = null;
        SE2AA4 = null;
        LO1 = null;
        LO2 = null;
        LO3 = null;
        LO4 = null;
        LO5 = null;
    }

	@Test
    public void testgetName1()
    {
        assertEquals(SE2AA4.getName(), "Software Design I");
    }

    @Test
    public void testgetName2()
    {
        assertNotSame(SE2AA4.getName(), "SE2AA4");
    }

    @Test
    public void testgetIndicators1Length()
    {
        assertEquals(SE2AA4.getIndicators().length, 10);
    }

    @Test
    public void testgetIndicators1Elements()
    {
        IndicatorT[] expected = {IndicatorT.modelSelect, IndicatorT.estOutcomes, IndicatorT.specEngKnow, IndicatorT.desPrinciples, IndicatorT.math,
		                                     IndicatorT.openEnded, IndicatorT.recogTheory, IndicatorT.suitableFund,
		                                     IndicatorT.assumpt, IndicatorT.desProcess};
        int counter = 0;
        for (int i = 0; i < SE2AA4.getIndicators().length; i++) {
            if(SE2AA4.getIndicators()[i] == expected[i]) {
            	counter = counter + 1;
            }
        }
        assertEquals(counter, SE2AA4.getIndicators().length);

    }

    @Test
    public void testgetIndicators2()
    {
    	IndicatorT[] expected = {IndicatorT.healthSafety, IndicatorT.standards, IndicatorT.specEngKnow, IndicatorT.desPrinciples, IndicatorT.math,
		                                     IndicatorT.openEnded, IndicatorT.recogTheory, IndicatorT.suitableFund,
		                                     IndicatorT.assumpt, IndicatorT.desProcess};
        int counter = 0;
        for (int i = 0; i < SE2AA4.getIndicators().length; i++) {
            if(SE2AA4.getIndicators()[i] == expected[i]) {
            	counter = counter + 1;
            }
        }
        assertNotSame(counter, SE2AA4.getIndicators().length);

    }

    @Test
    public void testgetLOs1()
    {
    	assertEquals(SE2AA4.getLOs(IndicatorT.standards).length, 0);

    }

    @Test
    public void testgetLOs2()
    {
		SE2AA4.addLO(IndicatorT.assumpt, LO1);
		SE2AA4.addLO(IndicatorT.assumpt, LO2);
		SE2AA4.addLO(IndicatorT.assumpt, LO3);
		SE2AA4.addLO(IndicatorT.assumpt, LO4);
        LOsT[] outcomes = new LOsT[]{LO2, LO3, LO1, LO4};
        for (int i = 0; i < outcomes.length; i++) {
        	assertEquals(outcomes[i].getName(), SE2AA4.getLOs(IndicatorT.assumpt)[i].getName());
        }
    }

    @Test
    public void testaddLO1()
    {
    	SE2AA4.addLO(IndicatorT.awarePEO, LO1);
    	for (int i = 0; i < SE2AA4.getLOs(IndicatorT.awarePEO).length; i++) {
    		assertEquals(SE2AA4.getLOs(IndicatorT.awarePEO)[i], LO1);
    	}
    }

    @Test
    public void testaddLO2()
    {
    	SE2AA4.addLO(IndicatorT.awarePEO, LO1);
    	for (int i = 0; i < SE2AA4.getLOs(IndicatorT.awarePEO).length; i++) {
    		assertNotSame(SE2AA4.getLOs(IndicatorT.awarePEO)[i], LO3);
    	}
    }

    @Test
    public void testdelLO1()
    {
    	SE2AA4.addLO(IndicatorT.awarePEO, LO1);
    	SE2AA4.addLO(IndicatorT.awarePEO, LO3);
    	SE2AA4.delLO(IndicatorT.awarePEO, LO1);
    	for (int i = 0; i < SE2AA4.getLOs(IndicatorT.awarePEO).length; i++) {
    		assertNotSame(SE2AA4.getLOs(IndicatorT.awarePEO)[i], LO1);
    	}
    }

    @Test
    public void testdelLO2()
    {
        SE2AA4.addLO(IndicatorT.awarePEO, LO1);
    	SE2AA4.addLO(IndicatorT.awarePEO, LO3);
    	SE2AA4.delLO(IndicatorT.awarePEO, LO1);
    	for (int i = 0; i < SE2AA4.getLOs(IndicatorT.awarePEO).length; i++) {
    		assertEquals(SE2AA4.getLOs(IndicatorT.awarePEO)[i], LO3);
    	}
    }

    @Test
    public void testmember1()
    {
    	LOsT[] expected = new LOsT[]{LO3, LO4};
    	SE2AA4.addLO(IndicatorT.awarePEO, LO1);
    	SE2AA4.addLO(IndicatorT.awarePEO, LO3);
    	SE2AA4.delLO(IndicatorT.awarePEO, LO1);
    	SE2AA4.addLO(IndicatorT.awarePEO, LO4);
    	SE2AA4.addLO(IndicatorT.awarePEO, LO2);
    	SE2AA4.delLO(IndicatorT.awarePEO, LO2);
        assertTrue(SE2AA4.member(IndicatorT.awarePEO, expected));
    }

    @Test
    public void testmember2()
    {
    	SE2AA4.addLO(IndicatorT.awarePEO, LO1);
    	SE2AA4.addLO(IndicatorT.awarePEO, LO3);
    	SE2AA4.delLO(IndicatorT.awarePEO, LO1);
    	SE2AA4.addLO(IndicatorT.awarePEO, LO4);
    	SE2AA4.addLO(IndicatorT.awarePEO, LO2);
    	SE2AA4.delLO(IndicatorT.awarePEO, LO2);
        assertFalse(SE2AA4.member(IndicatorT.specEngKnow, new LOsT[] {LO3, LO4}));
    }

    @Test (expected=UnsupportedOperationException.class)
    public void testmeasures() {
        SE2AA4.measures();
    }

    @Test 
    public void testmeasuresInd1() {
    	Norm.setNorms(false, false, false);
        SE2AA4.addLO(IndicatorT.desPrinciples, LO1);
        SE2AA4.addLO(IndicatorT.desProcess, LO2);
        SE2AA4.addLO(IndicatorT.openEnded, LO3);
        SE2AA4.addLO(IndicatorT.desPrinciples, LO4);
        SE2AA4.addLO(IndicatorT.desProcess, LO5);
        assertTrue(Arrays.equals(SE2AA4.measures(IndicatorT.desProcess), new double[]{14.0, 28.0, 76.0, 26.0}));
    }

    @Test 
    public void testmeasuresInd2() {
    	Norm.setNorms(false, false, false);
        SE2AA4.addLO(IndicatorT.desPrinciples, LO1);
        SE2AA4.addLO(IndicatorT.desProcess, LO2);
        SE2AA4.addLO(IndicatorT.openEnded, LO3);
        SE2AA4.addLO(IndicatorT.desPrinciples, LO4);
        SE2AA4.addLO(IndicatorT.desProcess, LO5);
        assertTrue(Arrays.equals(SE2AA4.measures(IndicatorT.assumpt), new double[]{0.0, 0.0, 0.0, 0.0}));
    }

    @Test 
    public void testmeasuresAtt1() {
    	Norm.setNorms(false, false, false);
        SE2AA4.addLO(IndicatorT.desPrinciples, LO1);
        SE2AA4.addLO(IndicatorT.desProcess, LO2);
        SE2AA4.addLO(IndicatorT.openEnded, LO3);
        SE2AA4.addLO(IndicatorT.desPrinciples, LO4);
        SE2AA4.addLO(IndicatorT.desProcess, LO5);
        assertTrue(Arrays.equals(SE2AA4.measures(Design), new double[]{53.0, 82.0, 210.0, 116.0}));
    }
    @Test 
    public void testmeasuresAtt2() {
        Norm.setNorms(false, false, false);
        SE2AA4.addLO(IndicatorT.desPrinciples, LO1);
        SE2AA4.addLO(IndicatorT.desProcess, LO2);
        SE2AA4.addLO(IndicatorT.openEnded, LO3);
        SE2AA4.addLO(IndicatorT.desPrinciples, LO4);
        SE2AA4.addLO(IndicatorT.desProcess, LO5);
        assertTrue(Arrays.equals(SE2AA4.measures(ProbSolving), new double[]{0.0, 0.0, 0.0, 0.0}));
    }




}
