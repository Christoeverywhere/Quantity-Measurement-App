public class QuantityMeasurementApp {

    // Static method for Feet comparison
    public static boolean compareFeet(double val1, double val2) {
        return new Feet(val1).equals(new Feet(val2));
    }

    // Static method for Inches comparison
    public static boolean compareInches(double val1, double val2) {
        return new Inches(val1).equals(new Inches(val2));
    }
}

class Feet {
    private final double value;
    public Feet(double value) { this.value = value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feet feet = (Feet) o;
        return Double.compare(feet.value, value) == 0;
    }
}

class Inches {
    private final double value;
    public Inches(double value) { this.value = value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inches inches = (Inches) o;
        return Double.compare(inches.value, value) == 0;
    }
}
