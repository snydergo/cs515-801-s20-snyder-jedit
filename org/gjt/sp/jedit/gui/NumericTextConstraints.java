package org.gjt.sp.jedit.gui;
import javax.swing.*;

public class NumericTextConstraints {
    private final boolean positiveOnly;
    private final boolean integerOnly;
    private Number minValue;
    private Number maxValue;

    public NumericTextConstraints (boolean positiveOnly, boolean integerOnly) {
        this.positiveOnly = positiveOnly;
        this.integerOnly = integerOnly;

        if (integerOnly)
        {
            minValue = positiveOnly ? new Integer(0) : Integer.MIN_VALUE;
            maxValue = Integer.MAX_VALUE;
        }
        else
        {
            minValue = positiveOnly ? new Float(0.0) : Float.MIN_VALUE;
            maxValue = Float.MAX_VALUE;
        }
    }

    public boolean isIntergerOnly() {
        return this.integerOnly;
    }

    public boolean isPositiveOnly() {
        return this.positiveOnly;
    }

    public Number getMinValue(){
        return this.minValue;
    }

    public Number getMaxValue(){
        return this.maxValue;
    }

    // set the minimum allowed value for this text field. If this NumericTextField
    // was constructed with positive only, then values less than zero are ignored.
    public void setMinValue(Number n)
    {
        if (positiveOnly)
        {
            float f = n.floatValue();
            if (f < 0.0)
                return;
        }

        if (integerOnly)
        {
            int i = n.intValue();
            int max = maxValue.intValue();
            if (i > max)
                return;
        }
        else
        {
            float f = n.floatValue();
            float max = maxValue.floatValue();
            if (f > max)
                return;
        }
        minValue = n;
    }

    // set the maximum allowed value for this text field. If this NumericTextField
    // was constructed with positive only, then values less than zero are ignored.
    public void setMaxValue(Number n)
    {
        if (positiveOnly)
        {
            float f = n.floatValue();
            if (f < 0)
                return;
        }

        if (integerOnly)
        {
            int i = n.intValue();
            int min = minValue.intValue();
            if (i < min)
                return;
        }
        else
        {
            float f = n.floatValue();
            float min = minValue.floatValue();
            if (f < min)
                return;
        }
        maxValue = n;
    }

}
