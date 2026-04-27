package com.measurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    @Test
    void testFeetToInches() {

        double result =
                QuantityLength.convert(
                        1.0,
                        LengthUnit.FEET,
                        LengthUnit.INCHES
                );

        assertEquals(
                12.0,
                result,
                0.000001
        );
    }
    @Test
    void testAddition_CrossUnit_FeetPlusInches() {

        QuantityLength a =
                new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength b =
                new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength result = a.add(b);

        assertEquals(
                2.0,
                result.getValue(),
                0.000001
        );
    }
    @Test
    void testAddition_CrossUnit_YardPlusFeet() {

        QuantityLength a =
                new QuantityLength(1.0, LengthUnit.YARDS);

        QuantityLength b =
                new QuantityLength(3.0, LengthUnit.FEET);

        QuantityLength result = a.add(b);

        assertEquals(
                2.0,
                result.getValue(),
                0.000001
        );
    }
    @Test
    void testAddition_WithZero() {

        QuantityLength a =
                new QuantityLength(5.0, LengthUnit.FEET);

        QuantityLength b =
                new QuantityLength(0.0, LengthUnit.INCHES);

        QuantityLength result = a.add(b);

        assertEquals(
                5.0,
                result.getValue(),
                0.000001
        );
    }

}