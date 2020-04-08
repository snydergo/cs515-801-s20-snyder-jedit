package org.gjt.sp.jedit.gui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumericTextConstraintsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testConstructor() {
        Number minValue;
        Number maxValue;

        NumericTextConstraints constraints = new NumericTextConstraints(true, true);
        assertTrue(constraints.isPositiveOnly());
        assertTrue(constraints.isIntergerOnly());
        minValue = constraints.getMinValue();
        assertTrue(minValue.equals(new Integer(0)));
        maxValue = constraints.getMaxValue();
        assertTrue(maxValue.equals(Integer.MAX_VALUE));

        constraints = new NumericTextConstraints(true, false);
        assertTrue(constraints.isPositiveOnly());
        assertFalse(constraints.isIntergerOnly());
        minValue = constraints.getMinValue();
        assertTrue(minValue.equals(new Float(0)));
        maxValue = constraints.getMaxValue();
        assertTrue(maxValue.equals(Float.MAX_VALUE));

        constraints = new NumericTextConstraints(false, true);
        assertFalse(constraints.isPositiveOnly());
        assertTrue(constraints.isIntergerOnly());
        minValue = constraints.getMinValue();
        assertTrue(minValue.equals(Integer.MIN_VALUE));
        maxValue = constraints.getMaxValue();
        assertTrue(maxValue.equals(Integer.MAX_VALUE));

        constraints = new NumericTextConstraints(false, false);
        assertFalse(constraints.isPositiveOnly());
        assertFalse(constraints.isIntergerOnly());
        minValue = constraints.getMinValue();
        assertTrue(minValue.equals(Float.MIN_VALUE));
        maxValue = constraints.getMaxValue();
        assertTrue(maxValue.equals(Float.MAX_VALUE));
    }

    @Test
    public void textMaxAndMinFloat(){
        Number minValue;
        Number maxValue;

        NumericTextConstraints constraints = new NumericTextConstraints(true, false);

        /* Test maxValue */
        constraints.setMaxValue(20.5);
        maxValue = constraints.getMaxValue();
        assertTrue(maxValue.equals(20.5));

        constraints.setMaxValue(-10.5);
        maxValue = constraints.getMaxValue();
        assertFalse(maxValue.equals(-10.5));

        constraints.setMaxValue(0);
        maxValue = constraints.getMaxValue();
        assertTrue(maxValue.equals(0));

        constraints.setMaxValue(20.5);

        /* Test minValue */
        constraints.setMinValue(20.5);
        minValue = constraints.getMinValue();
        assertTrue(minValue.equals(20.5));

        constraints.setMinValue(-10.5);
        minValue = constraints.getMinValue();
        assertFalse(minValue.equals(-10.5));

        constraints.setMinValue(10);
        minValue = constraints.getMinValue();
        assertTrue(minValue.equals(10));

        constraints = new NumericTextConstraints(false, false);

        /* Test maxValue */
        constraints.setMaxValue(20.5);
        maxValue = constraints.getMaxValue();
        assertTrue(maxValue.equals(20.5));

        constraints.setMaxValue(-10.5);
        maxValue = constraints.getMaxValue();
        assertFalse(maxValue.equals(-10.5));

        constraints.setMaxValue(0);
        maxValue = constraints.getMaxValue();
        assertFalse(maxValue.equals(0));

        constraints.setMaxValue(20.5);

        /* Test minValue */
        constraints.setMinValue(20.5);
        minValue = constraints.getMinValue();
        assertTrue(minValue.equals(20.5));

        constraints.setMinValue(-10.5);
        minValue = constraints.getMinValue();
        assertTrue(minValue.equals(-10.5));

        constraints.setMinValue(0);
        minValue = constraints.getMinValue();
        assertTrue(minValue.equals(0));
    }

    @Test
    public void testMaxAndMinInteger() {
        Number maxValue;
        Number minValue;

        NumericTextConstraints constraints = new NumericTextConstraints(true, true);

        /* Test maxValue */
        constraints.setMaxValue(20);
        maxValue = constraints.getMaxValue();
        assertTrue(maxValue.equals(20));

        constraints.setMaxValue(-10);
        maxValue = constraints.getMaxValue();
        assertFalse(maxValue.equals(-10));

        constraints.setMaxValue(0);
        maxValue = constraints.getMaxValue();
        assertTrue(maxValue.equals(0));

        constraints.setMaxValue(20);

        /* Test minValue */
        constraints.setMinValue(20);
        minValue = constraints.getMinValue();
        assertTrue(minValue.equals(20));

        constraints.setMinValue(-10);
        minValue = constraints.getMinValue();
        assertFalse(minValue.equals(-10));

        constraints.setMinValue(0);
        minValue = constraints.getMinValue();
        assertTrue(minValue.equals(0));

        constraints = new NumericTextConstraints(false, true);

        /* Test maxValue */
        constraints.setMaxValue(20);
        maxValue = constraints.getMaxValue();
        assertTrue(maxValue.equals(20));

        constraints.setMaxValue(-10);
        maxValue = constraints.getMaxValue();
        assertTrue(maxValue.equals(-10));

        constraints.setMaxValue(0);
        maxValue = constraints.getMaxValue();
        assertTrue(maxValue.equals(0));

        constraints.setMaxValue(20);

        /* Test minValue */
        constraints.setMinValue(20);
        minValue = constraints.getMinValue();
        assertTrue(minValue.equals(20));

        constraints.setMinValue(-10);
        minValue = constraints.getMinValue();
        assertTrue(minValue.equals(-10));

        constraints.setMinValue(0);
        minValue = constraints.getMinValue();
        assertTrue(minValue.equals(0));
    }
}