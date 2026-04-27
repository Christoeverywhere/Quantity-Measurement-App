package com.measurement;

public final class QuantityLength {

    private final double value;
    private final LengthUnit unit;

    private static final double EPSILON = 1e-6;

    public QuantityLength(double value, LengthUnit unit) {

        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid value");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    // UC5 Convert
    public QuantityLength convertTo(LengthUnit targetUnit) {

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double baseValue =
                unit.convertToBaseUnit(value);

        double convertedValue =
                targetUnit.convertFromBaseUnit(baseValue);

        return new QuantityLength(
                convertedValue,
                targetUnit
        );
    }

    // UC6 Add (default = first unit)
    public QuantityLength add(QuantityLength other) {

        return add(other, this.unit);
    }

    // UC7 Add with explicit target unit
    public QuantityLength add(
            QuantityLength other,
            LengthUnit targetUnit) {

        if (other == null)
            throw new IllegalArgumentException("Other length cannot be null");

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        // Convert both → base unit
        double base1 =
                unit.convertToBaseUnit(value);

        double base2 =
                other.unit.convertToBaseUnit(
                        other.value);

        // Add
        double baseSum = base1 + base2;

        // Convert → target unit
        double result =
                targetUnit.convertFromBaseUnit(
                        baseSum);

        return new QuantityLength(
                result,
                targetUnit
        );
    }

    // Equality
    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof QuantityLength))
            return false;

        QuantityLength other =
                (QuantityLength) obj;

        double base1 =
                unit.convertToBaseUnit(value);

        double base2 =
                other.unit.convertToBaseUnit(
                        other.value);

        return Math.abs(base1 - base2)
                < EPSILON;
    }
}