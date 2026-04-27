package com.measurement;

/**
 * Immutable class representing weight quantity.
 */
public final class QuantityWeight {

    private final double value;
    private final WeightUnit unit;

    private static final double EPSILON = 1e-6;

    public QuantityWeight(double value,
                          WeightUnit unit) {

        if (unit == null)
            throw new IllegalArgumentException(
                    "Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException(
                    "Invalid value");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public WeightUnit getUnit() {
        return unit;
    }

    /**
     * Convert weight to another unit
     */
    public QuantityWeight convertTo(
            WeightUnit targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException(
                    "Target unit cannot be null");

        double baseValue =
                unit.convertToBaseUnit(value);

        double convertedValue =
                targetUnit.convertFromBaseUnit(
                        baseValue);

        return new QuantityWeight(
                convertedValue,
                targetUnit
        );
    }

    /**
     * Add weight (default unit = first operand)
     */
    public QuantityWeight add(
            QuantityWeight other) {

        return add(other, this.unit);
    }

    /**
     * Add weight with explicit target unit
     */
    public QuantityWeight add(
            QuantityWeight other,
            WeightUnit targetUnit) {

        if (other == null)
            throw new IllegalArgumentException(
                    "Other weight cannot be null");

        if (targetUnit == null)
            throw new IllegalArgumentException(
                    "Target unit cannot be null");

        double base1 =
                unit.convertToBaseUnit(value);

        double base2 =
                other.unit.convertToBaseUnit(
                        other.value);

        double baseSum = base1 + base2;

        double result =
                targetUnit.convertFromBaseUnit(
                        baseSum);

        return new QuantityWeight(
                result,
                targetUnit
        );
    }

    /**
     * Equality check
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null ||
                getClass() != obj.getClass())
            return false;

        QuantityWeight other =
                (QuantityWeight) obj;

        double base1 =
                unit.convertToBaseUnit(value);

        double base2 =
                other.unit.convertToBaseUnit(
                        other.value);

        return Math.abs(base1 - base2)
                < EPSILON;
    }

    /**
     * hashCode override (important!)
     */
    @Override
    public int hashCode() {

        double base =
                unit.convertToBaseUnit(value);

        return Double.hashCode(base);
    }

    @Override
    public String toString() {

        return value + " " + unit;
    }
}