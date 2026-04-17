package com.measurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) {
        System.out.println("=== UC4: Extended Unit Support (DRY Principle) ===");

        // Yard to Feet Comparison
        compare(new Quantity(1.0, LengthUnit.YARDS), new Quantity(3.0, LengthUnit.FEET));

        // Yard to Inch Comparison
        compare(new Quantity(1.0, LengthUnit.YARDS), new Quantity(36.0, LengthUnit.INCH));

        // Inch to Inch Comparison
        compare(new Quantity(1.0, LengthUnit.INCH), new Quantity(1.0, LengthUnit.INCH));

        // Centimeter to Inch Comparison (UC4 specific)
        compare(new Quantity(1.0, LengthUnit.CENTIMETER), new Quantity(0.393701, LengthUnit.INCH));

        // Centimeter to Centimeter Comparison
        compare(new Quantity(2.0, LengthUnit.CENTIMETER), new Quantity(2.0, LengthUnit.CENTIMETER));

        // Negative Test: Yard to Feet
        compare(new Quantity(1.0, LengthUnit.YARDS), new Quantity(2.0, LengthUnit.FEET));
    }

    private static void compare(Quantity q1, Quantity q2) {
        boolean result = q1.equals(q2);
        System.out.println("Input:  Quantity(" + q1 + ") and Quantity(" + q2 + ")");
        System.out.println("Output: Equal (" + result + ")");
        System.out.println("---------------------------------------------------------");
    }
}