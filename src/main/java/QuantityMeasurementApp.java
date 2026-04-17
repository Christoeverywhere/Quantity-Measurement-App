public class QuantityMeasurementApp {
    private final double value;
    private final LengthUnit unit;

    public Quantity(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        // 1. Reference Check (Reflexive)
        if (this == o) return true;

        // 2. Null and Type Check
        if (o == null || getClass() != o.getClass()) return false;

        Quantity that = (Quantity) o;

        // 3. Comparison logic using the base unit (Inches)
        double value1 = this.unit.convertToBase(this.value);
        double value2 = that.unit.convertToBase(that.value);

        return Double.compare(value1, value2) == 0;
    }

    @Override
    public int hashCode() {
        // Best practice: always override hashCode when overriding equals
        return Double.hashCode(unit.convertToBase(value));
    }
}