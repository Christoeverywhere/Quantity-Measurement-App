package com.measurement;

public enum LengthUnit {

    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(1.0 / 30.48);

    private final double conversionFactor; // to FEET (base)

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    // UC8 Responsibility 1
    // Convert this unit → base unit (FEET)
    public double convertToBaseUnit(double value) {
        return value * conversionFactor;
    }

    // UC8 Responsibility 2
    // Convert base unit → this unit
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactor;
    }
}