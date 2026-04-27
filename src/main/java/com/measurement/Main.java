package com.measurement;

public class Main {

    public static void main(String[] args) {

        QuantityWeight w1 =
                new QuantityWeight(
                        1.0,
                        WeightUnit.KILOGRAM);

        QuantityWeight w2 =
                new QuantityWeight(
                        1000.0,
                        WeightUnit.GRAM);

        System.out.println(
                w1.equals(w2)
        );

        QuantityWeight result =
                w1.add(w2);

        System.out.println(
                result
        );

        QuantityWeight pounds =
                w1.convertTo(
                        WeightUnit.POUND);

        System.out.println(
                pounds
        );
    }
}