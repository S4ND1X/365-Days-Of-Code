import java.util.*;

// !The Fibonacci sequence is defined as follows: 
//     the first number of the sequence is 0, the second number is 1, 
//     and the nth number is the sum of the (n - 1)th and (n - 2)th numbers. 
//     Write a function that takes in an integer n and returns the nth Fibonacci number.
//! Important note: 
//    the Fibonacci sequence is often defined with its first 2 numbers as F0 = 0 and F1 = 1. 
//    For the purpose of this question, the first Fibonacci number is F0; 
//    therefore, getNthFib(1) is equal to F0, getNthFib(2) is equal to F1, etc..
// !Test cases:
//     n=1 -> 2
//     n=6 -> 5

public class NthFibonacci{

    /** 
    *! "Brute force" way
    ** Time O(2^n)
    ** Space O(n)
    **/
    private static int getNthFib(int n) {

        //*Casos Base
        if(n==2) { return 1; }
        else if (n==1) { return 0;}
        else
            //*Secuencia
            return getNthFib(n - 1) + getNthFib(n - 2);
    }

    /** 
    *! "Memo" way
    ** Time O(n)
    ** Space O(n)
    **/

    private static int getNthFibMem(int n) {
        Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
        memo.put(1, 0);
        memo.put(2, 1);
        return getNthFibMem(n,memo);
    }

    private static int getNthFibMem(int n, Map<Integer,Integer> memo) {
        if(memo.containsKey(n)){
            return memo.get(n);
        }else{
            memo.put(n, getNthFibMem(n - 1, memo) + getNthFibMem(n - 2, memo));
            return memo.get(n);
        }
    }

    public static void main(String[] args) {

        System.out.println(getNthFib(6));
        System.out.println(getNthFib(12));
        System.out.println(getNthFib(1));

        System.out.println(getNthFibMem(6));
        System.out.println(getNthFibMem(12));
        System.out.println(getNthFibMem(1));

    }
}