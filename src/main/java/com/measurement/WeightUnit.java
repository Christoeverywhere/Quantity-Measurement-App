package com.measurement;

/**
 * Standalone enum for weight units.
 * Base unit = KILOGRAM
 */
public enum WeightUnit {

    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    private final double conversionFactor;

    WeightUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    /**
     * Convert value → base unit (kg)
     */
    public double convertToBaseUnit(double value) {
        return value * conversionFactor;
    }

    /**
     * Convert base unit → this unit
     */
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactor;
    }
}