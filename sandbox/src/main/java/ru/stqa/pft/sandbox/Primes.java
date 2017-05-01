package ru.stqa.pft.sandbox;

/**
 * Created by Mari on 4/29/17.
 */
public class Primes {
  public static boolean isPrime(int n){
    for ( int i=2; i<n; i = i+1){
      if (n % i == 0){
        return false;
      }
    }
    return true;
  }


  public static boolean isPrimeWhile(int n){
    int i =2;
    while (i<n){
      if (n % i == 0){
        return false;
      }
      i++;
    }
    return true;
  }
}
