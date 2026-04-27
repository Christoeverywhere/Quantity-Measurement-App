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

}