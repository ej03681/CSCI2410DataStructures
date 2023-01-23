package datastructures2018;

import java.util.Scanner;

/**
 *
 * @author EddyJ
 */
public class RecursiveSumDigi {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an Integer: ");
        int n = input.nextInt();
        System.out.println("The sum of digits in " + n + " is " + sumDigits(n));
        
    }
    public static long sumDigits(long n){
       if (n > 0)
         return n % 10 + sumDigits(n / 10);
         else 
         return 0;
    }
}
