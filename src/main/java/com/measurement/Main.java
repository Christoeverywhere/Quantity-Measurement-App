package com.measurement;

public class Main {

    public static void main(String[] args) {

        double result =
                QuantityLength.convert(
                        1.0,
                        LengthUnit.FEET,
                        LengthUnit.INCHES
                );

        System.out.println("1 foot = " + result + " inches");

        // Example object usage
        QuantityLength length =
                new com.measurement.QuantityLength(2.0, LengthUnit.YARDS);

        QuantityLength converted =
                length.convertTo(LengthUnit.FEET);

        System.out.println(
                "2 yards = " +
                        converted.getValue() +
                        " feet"
        );
    }
}