/**
 * Author: Hamrish Saravanakumar
 * Revised: March 29 2021
 * 
 * Description: Tester File for AttributeT  
 */

package src;

import org.junit.*;
import static org.junit.Assert.*;

import src.AttributeT;
import src.IndicatorT;

import java.util.HashSet;

public class TestAttributeT
{
    private AttributeT ProbSolving;
    private AttributeT Design;

    @Before
    public void setUp() {
        ProbSolving = new AttributeT("Problem Solving", new IndicatorT[] {IndicatorT.recogTheory, IndicatorT.modelSelect,
                                                                                        IndicatorT.estOutcomes});

        Design = new AttributeT("Design", new IndicatorT[] {IndicatorT.desProcess, IndicatorT.desPrinciples,
                                                                        IndicatorT.openEnded, IndicatorT.ideaGeneration,
                                                                        IndicatorT.healthSafety, IndicatorT.standards});
    }

    @After
    public void tearDown() {
        ProbSolving = null;
        Design = null;
    }

    @Test
    public void testgetName1()
    {
        assertNotSame(ProbSolving.getName(), "ProbSolving");
    }

    @Test
    public void testgetName2()
    {
        assertEquals(Design.getName(), "Design");
    }

    @Test
    public void testgetIndicators1Length()
    {
        assertEquals(ProbSolving.getIndicators().length, 3);
    }

    @Test
    public void testgetIndicators1Elements()
    {
        IndicatorT[] expected = {IndicatorT.modelSelect, IndicatorT.estOutcomes, IndicatorT.recogTheory};
        int counter = 0;
        for (int i = 0; i < ProbSolving.getIndicators().length; i++) {
            if (ProbSolving.getIndicators()[i] == expected[i]) {
                counter = counter + 1;
            }
        }
        assertEquals(counter, expected.length);
    }

    @Test
    public void testgetIndicators2()
    {
        assertNotSame(Design.getIndicators(), new IndicatorT[] {IndicatorT.desProcess, IndicatorT.desPrinciples});
    }

}
