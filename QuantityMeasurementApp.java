public class QuantityMeasurementApp {

    // Inner class representing Feet measurement
    static class Feet {
        private final double value;

        // Constructor
        public Feet(double value) {
            this.value = value;
        }

        // Override equals method
        @Override
        public boolean equals(Object obj) {

            // Same reference check (reflexive)
            if (this == obj) {
                return true;
            }

            // Null check
            if (obj == null) {
                return false;
            }

            // Type check
            if (this.getClass() != obj.getClass()) {
                return false;
            }

            // Safe casting
            Feet other = (Feet) obj;

            // Compare double values correctly
            return Double.compare(this.value, other.value) == 0;
        }
    }

    // Main method to test manually
    public static void main(String[] args) {
        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);

        System.out.println("Are equal? " + f1.equals(f2)); // true
    }
}