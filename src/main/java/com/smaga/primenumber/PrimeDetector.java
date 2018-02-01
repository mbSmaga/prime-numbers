package com.smaga.primenumber;

public class PrimeDetector {

    public static boolean isPrime(int positiveInteger) throws IllegalArgumentException {
        if (positiveInteger < 1) throw new IllegalArgumentException("Provided number can not be prime number." + positiveInteger);
        for (int i = 2; i <= Math.sqrt(positiveInteger); i++) {
            if (positiveInteger % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int getFirstDivider(int positiveInteger) throws IllegalArgumentException {
        if (positiveInteger < 1) throw new IllegalArgumentException("Method accepts only positive intigers." + positiveInteger);
        for (int i = 2; i <= Math.sqrt(positiveInteger); i++) {
            if (positiveInteger % i == 0) {
                return i;
            }
        }
        return positiveInteger;
    }
}
