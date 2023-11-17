package com.example;

import java.util.Arrays;

public class Algorithms {

    /**
     * Sieve Of Eratosthenes for finding all prime numbers
     * from 1..n.
     * @param n range to find the primes untill
     * @return boolean[] contains the value true/false at each index
     * indicating whether it's prime or not.
     */
    public boolean[] sieveEratosthenes(int n) {
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes, true);

        for(int i = 2; i * i <= n; i++) {
            //iterate through 2 multiple of i and jump by i
            for(int j = 2*i; j <=n; j +=i) {
                primes[j] = false;
            }
        }
        return primes;
    }

    /**
     * Finding the greatest common divisor of a and b
     * @param a first number
     * @param b second number
     * @return greatest common divisor of a & b.
     */
    public int greatestCommonDivisor(int a, int b) {
        if(b == 0) return a;
        return greatestCommonDivisor(b, a % b);
    }
}
