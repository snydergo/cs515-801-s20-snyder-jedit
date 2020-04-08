package org.gjt.sp.jedit.gui;

import java.util.ArrayList;
import java.util.List;

import org.gjt.sp.jedit.jEdit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumericTextFieldTest {

    @Before
    public void setUp() throws Exception {
        jEdit.initSystemProperties();
    }

    @After
    public void tearDown() throws Exception {

    }

    private Number getValueWithConstraints(String text, Boolean positiveOnly, Boolean integerOnly, Float minMargin, Float maxMargin){
        NumericTextField textField = new NumericTextField(text, positiveOnly, integerOnly);
        textField.getConstraints().setMinValue(integerOnly ? new Integer(minMargin.intValue()) : new Float(minMargin));
        textField.getConstraints().setMaxValue(integerOnly ? new Integer(maxMargin.intValue()) : new Float(maxMargin));

        return textField.getValue();
    }

    @Test
    public void testTextFieldValuesPositiveInteger() {
        Boolean positiveOnly = Boolean.TRUE;
        Boolean integerOnly = Boolean.TRUE;
        Number number = null;
        number = getValueWithConstraints(new String("-20"), positiveOnly, integerOnly, new Float(-20), new Float(20));
        assertTrue(number.equals(-20));
        try {
            number = getValueWithConstraints(new String("-20.5"), positiveOnly, integerOnly, new Float(-20), new Float(20));
            assertTrue(Boolean.FALSE);
        } catch(NumberFormatException e) {
            assertTrue(Boolean.TRUE);
        }
        try {
            number = getValueWithConstraints(new String("-10.5"), positiveOnly, integerOnly, new Float(-20), new Float(20));
            assertTrue(Boolean.FALSE);
        } catch(NumberFormatException e) {
            assertTrue(Boolean.TRUE);
        }
        number = getValueWithConstraints(new String("-5"), positiveOnly, integerOnly, new Float(-20), new Float(20));
        assertTrue(number.equals(-5));
        number = getValueWithConstraints(new String("0"), positiveOnly, integerOnly, new Float(-20), new Float(20));
        assertTrue(number.equals(0));
        number = getValueWithConstraints(new String("5"), positiveOnly, integerOnly, new Float(-20), new Float(20));
        assertTrue(number.equals(5));
        try {
            number = getValueWithConstraints(new String("20.5"), positiveOnly, integerOnly, new Float(-20), new Float(20));
            assertTrue(Boolean.FALSE);
        }catch(NumberFormatException e) {
            assertTrue(Boolean.TRUE);
        }
        try {
            number = getValueWithConstraints(new String("10.5"), positiveOnly, integerOnly, new Float(-20), new Float(20));
            assertTrue(Boolean.FALSE);
        }catch(NumberFormatException e) {
            assertTrue(Boolean.TRUE);
        }

        number = getValueWithConstraints(new String("20"), positiveOnly, integerOnly, new Float(-20), new Float(20));
        assertTrue(number.equals(20));
    }

    @Test
    public void testTextFieldValuesPositiveFloat() {
        Boolean positiveOnly = Boolean.TRUE;
        Boolean integerOnly = Boolean.FALSE;
        Number number = null;
        number = getValueWithConstraints(new String("-20"), positiveOnly, integerOnly, new Float(-20), new Float(20));
        assertTrue(number.equals(new Float(-20)));

        number = getValueWithConstraints(new String("-20.5"), positiveOnly, integerOnly, new Float(-20), new Float(20));
        assertTrue(number.equals(new Float(-20.5)));

        number = getValueWithConstraints(new String("-10.5"), positiveOnly, integerOnly, new Float(-20), new Float(20));
        assertTrue(number.equals(new Float(-10.5)));

        number = getValueWithConstraints(new String("-5"), positiveOnly, integerOnly, new Float(-20), new Float(20));
        assertTrue(number.equals(new Float(-5)));

        number = getValueWithConstraints(new String("0"), positiveOnly, integerOnly, new Float(-20), new Float(20));
        assertTrue(number.equals(new Float(0)));

        number = getValueWithConstraints(new String("5"), positiveOnly, integerOnly, new Float(-20), new Float(20));
        assertTrue(number.equals(new Float(5)));

        number = getValueWithConstraints(new String("10.5"), positiveOnly, integerOnly, new Float(-20), new Float(20));
        assertTrue(number.equals(new Float(10.5)));

        number = getValueWithConstraints(new String("20"), positiveOnly, integerOnly, new Float(-20), new Float(20));
        assertTrue(number.equals(new Float(20)));
    }
}