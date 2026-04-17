import org.junit.jupiter.api.Test;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class QuantityMeasurementAppTest {

    @org.testng.annotations.Test
    public void givenSameFeetValues_shouldReturnTrue() {
        assertTrue(QuantityMeasurementApp.compareFeet(1.0, 1.0));
    }

    @Test
    public void givenDifferentFeetValues_shouldReturnFalse() {
        assertFalse(QuantityMeasurementApp.compareFeet(1.0, 2.0));
    }

    @Test
    public void givenSameInchesValues_shouldReturnTrue() {
        assertTrue(QuantityMeasurementApp.compareInches(1.0, 1.0));
    }

    @Test
    public void givenDifferentInchesValues_shouldReturnFalse() {
        assertFalse(QuantityMeasurementApp.compareInches(1.0, 2.0));
    }
}