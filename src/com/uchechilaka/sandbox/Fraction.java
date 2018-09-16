package com.uchechilaka.sandbox;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Denominator MUST not be zero");
//        All good!
        this.numerator = numerator;
        if (denominator < 0) {
            this.denominator = Math.abs(denominator);
            this.numerator *= -1;
        } else {
            this.denominator = denominator;
        }
//        System.out.println(String.format("New fraction: %s/%s", this.numerator, this.denominator));
    }

    public Fraction(int numerator) {
        this(numerator, 1);
    }

    public Fraction() {
        this(0, 1);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public String toString() {
        return String.format("%s/%s", numerator, denominator);
    }

    public Double toDouble() {
        return (numerator * 1.0) / denominator;
    }

    /**
     * Reduce the fraction instance to its lowest terms
     */
    public void toLowestTerms() {
        int gcd = gcd(numerator, denominator);
//        System.out.println(String.format("gcd between %s and %s = %s", numerator, denominator, gcd));
//        System.out.println(String.format("Fraction as double: %s", this.toDouble()));
        numerator = numerator / gcd;
        denominator = denominator / gcd;
//        System.out.println(String.format("New fraction: %s", this.toString()));
//        System.out.println(String.format("Fraction as double: %s", this.toDouble()));
    }

    /**
     * Greatest Common Divisor (GCD)
     * @param a
     * @param b
     * @return
     */
    public static int gcd(int a, int b) {
        while (a != 0 && b != 0) {
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }

    /**
     * Add the fraction instance other to this fraction instance
     * @param other
     * @return
     */
    public Fraction add(Fraction other) {
        int newDenominator = denominator * other.getDenominator();
        Fraction result = new Fraction((numerator * other.getDenominator()) + (other.getNumerator() * denominator), newDenominator);
        result.toLowestTerms();
        return result;
    }

    public Fraction subtract(Fraction other) {
        int newDenominator = denominator * other.getDenominator();
        Fraction result = new Fraction((numerator * other.getDenominator()) - (other.getNumerator() * denominator), newDenominator);
        result.toLowestTerms();
        return result;
    }

    public Fraction multiply(Fraction other) {
        Fraction result = new Fraction(numerator * other.getNumerator(), denominator * other.getDenominator());
        result.toLowestTerms();
        return result;
    }

    public Fraction divide(Fraction other) {
        Fraction result = new Fraction(numerator * other.getDenominator(), denominator * other.getNumerator());
        result.toLowestTerms();
        return result;
    }

    public boolean equals(Object other) {
        Fraction otherFraction = (Fraction) other;
        return this.toDouble().equals(otherFraction.toDouble());
    }
}
