/**
 * Author: Hamrish Saravanakumar
 * Revised: March 29 2021
 * 
 * Description: Tester File for ProgramT  
 */

package src;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.Arrays;

public class TestProgramT
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
    private ProgramT iBiomed;

    @Before
    public void setUp() {

		SE2AA4_indicators = new IndicatorT[] {IndicatorT.math, IndicatorT.specEngKnow, IndicatorT.assumpt,
		                                     IndicatorT.suitableFund, IndicatorT.recogTheory, IndicatorT.modelSelect,
		                                     IndicatorT.estOutcomes, IndicatorT.desProcess, IndicatorT.desPrinciples,
		                                     IndicatorT.openEnded, IndicatorT.tools, IndicatorT.engInSoc,
		                                     IndicatorT.awarePEO};

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

        iBiomed = new ProgramT();

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
        iBiomed = null;
    }

    @Test (expected=UnsupportedOperationException.class)
    public void testmeasures() {
        iBiomed.measures();
    }

    @Test (expected=UnsupportedOperationException.class)
    public void testmeasuresInd() {
        iBiomed.measures(IndicatorT.desPrinciples);
    }

    @Test
    public void testmeasuresAtt1()
    {
    	SE2AA4.addLO(IndicatorT.desProcess, LO1);
    	SE2AA4.addLO(IndicatorT.desPrinciples, LO2);
    	SE2AA4.addLO(IndicatorT.recogTheory, LO3);
    	SE2AA4.addLO(IndicatorT.desProcess, LO4);
     	SE2AA4.addLO(IndicatorT.openEnded, LO5);
    	iBiomed.add(SE2AA4);
        assertTrue(Arrays.equals(iBiomed.measures(Design), new double[]{0.10614525139664804, 0.2122905027932961, 0.3687150837988827, 0.3128491620111732}));
    }

    @Test
    public void testmeasuresAtt2()
    {
    	SE2AA4.addLO(IndicatorT.desProcess, LO1);
    	SE2AA4.addLO(IndicatorT.desPrinciples, LO2);
    	SE2AA4.addLO(IndicatorT.recogTheory, LO3);
    	SE2AA4.addLO(IndicatorT.desProcess, LO4);
     	SE2AA4.addLO(IndicatorT.openEnded, LO5);
    	iBiomed.add(SE2AA4);
        assertFalse(Arrays.equals(iBiomed.measures(ProbSolving), new double[]{0.10614525139664804, 0.2122905027932961, 0.3687150837988827, 0.3128491620111732}));
    }



}
