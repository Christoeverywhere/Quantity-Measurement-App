package com.measurement;

/**
 * Immutable class representing a length quantity.
 * Supports UC5 unit-to-unit conversion.
 */
public final class QuantityLength {

    private final double value;
    private final LengthUnit unit;

    private static final double EPSILON = 1e-6;

    /**
     * Constructor
     */
    public QuantityLength(double value,
                          LengthUnit unit) {

        validateValue(value);
        validateUnit(unit);

        this.value = value;
        this.unit = unit;
    }

    /**
     * UC5 Static Conversion Method
     */
    public static double convert(
            double value,
            LengthUnit source,
            LengthUnit target) {

        validateValue(value);
        validateUnit(source);
        validateUnit(target);

        // Convert source → base (feet)
        double valueInFeet =
                value * source.getConversionFactor();

        // Convert base → target
        double result =
                valueInFeet /
                        target.getConversionFactor();

        return result;
    }

    /**
     * Instance conversion method
     */
    public QuantityLength convertTo(
            LengthUnit targetUnit) {

        double convertedValue =
                convert(value,
                        unit,
                        targetUnit);

        return new QuantityLength(
                convertedValue,
                targetUnit
        );
    }

    /**
     * Convert to base unit
     */
    private double toBaseUnit() {

        return value *
                unit.getConversionFactor();
    }

    /**
     * Validation methods
     */
    private static void validateValue(
            double value) {

        if (!Double.isFinite(value)) {

            throw new IllegalArgumentException(
                    "Value must be finite"
            );
        }
    }

    private static void validateUnit(
            LengthUnit unit) {

        if (unit == null) {

            throw new IllegalArgumentException(
                    "Unit cannot be null"
            );
        }
    }

    /**
     * equals() override
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof QuantityLength))
            return false;

        QuantityLength other =
                (QuantityLength) obj;

        return Math.abs(
                this.toBaseUnit()
                        - other.toBaseUnit()
        ) < EPSILON;
    }

    /**
     * toString() override
     */
    @Override
    public String toString() {

        return value + " " + unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }
    public QuantityLength add(QuantityLength other) {

        // Validate
        if (other == null) {
            throw new IllegalArgumentException("Second length cannot be null");
        }

        validateValue(this.value);
        validateValue(other.value);

        validateUnit(this.unit);
        validateUnit(other.unit);

        // Convert both to base unit (feet)
        double thisInFeet =
                this.value * this.unit.getConversionFactor();

        double otherInFeet =
                other.value * other.unit.getConversionFactor();

        // Add values in base unit
        double sumInFeet = thisInFeet + otherInFeet;

        // Convert back to unit of first operand
        double resultValue =
                sumInFeet / this.unit.getConversionFactor();

        // Return new object (immutability)
        return new QuantityLength(resultValue, this.unit);
    }
}