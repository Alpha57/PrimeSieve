package com.example.prime;

import java.util.ArrayList;
import java.util.BitSet;

/**
 * Return the prime list.
 */
public class PrimeData {

    // Calculate the primes using the classic Sieve method.
    // Calculate from 2 to n.
    public static ArrayList<Integer> sieve(int n) {
        ArrayList<Integer> primes = new ArrayList<Integer>();
        BitSet nonPrimes = new BitSet(n + 1);

        for (int p = 2; p <= n; p = nonPrimes.nextClearBit(p + 1)) {
            for (int i = p * p; i <= n; i += p) {
                nonPrimes.set(i);
            }
            primes.add(p);  // add this prime to the list of primes
        }
        return primes;
    }


    public static ArrayList<Prime> primeList() {
        // Calculate the primes up to 1000.
        ArrayList<Integer> myprimes = sieve(1000);
        ArrayList<Prime> list = new ArrayList<>();
        for (int i = 0; i < myprimes.size(); i++) {
          Prime another = new Prime();
          another.pnumber = myprimes.get(i);
          list.add(another);
        }
        return (list);
    }


    public static Prime getItem(String _id) {
        for (Prime aprime : primeList()) {
          if (aprime.pnumber.equals(_id)) {
            return aprime;
          }
        }
    return null;
    }
}
