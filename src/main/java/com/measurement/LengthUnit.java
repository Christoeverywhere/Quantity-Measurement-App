package com.measurement;

public enum LengthUnit {

    CENTIMETERS(0.0328084),
    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }
}