package com.uchechilaka.sandbox;

import java.util.Scanner;
import java.util.regex.*;

public class FractionCalculator {

    protected String getOperation(Scanner input) {
        System.out.print("Please enter an operation (+, -, /, *, = or Q to quit):");
        String operation = input.next();
        if(operation.toLowerCase().startsWith("q")) {
            System.exit(0);
        }
        Pattern p = Pattern.compile("^[+--*/=]$");
        Matcher m = p.matcher(operation);
        if(!m.matches()) {
            System.out.print("Invalid operation. Try again. ");
            return getOperation(input);
        }
//        Valid operation!
        return operation;
    }

    public static void main(String[] args) {
////        Some initial test code
//        Fraction negativeDenominator = new Fraction(2,-4);
//        Fraction negativeBoth = new Fraction(-1,-49);
//        Fraction negativeNumerator = new Fraction(-8,16);
//        Test gcd
        Fraction gcdTest = new Fraction(105, 147);
//        int gcd = gcdTest.gcd(gcdTest.getNumerator(), gcdTest.getDenominator());
//        System.out.println(String.format("gcd between %s and %s = %s", gcdTest.getNumerator(), gcdTest.getDenominator(), gcd));
        gcdTest.toLowestTerms();
//        Test gcd with non-starter fraction
        Fraction gcdTest2 = new Fraction(11,12);
        gcdTest2.toLowestTerms();
//        Test division
        Fraction half = new Fraction(1, 2);
        Fraction shouldBeQuarter = half.divide(new Fraction(2));
        System.out.println(String.format("Result of %s divided by %s = %s", half.toString(), 2, shouldBeQuarter.toString()));
    }
}
