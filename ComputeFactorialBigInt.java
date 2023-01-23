/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures2018;



import java.math.BigInteger;
import java.util.Scanner;
public class ComputeFactorialBigInt {
public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.print("Enter an integer of any size: ");
    BigInteger n = input.nextBigInteger();
    System.out.println(n + " is \n"+ factorial(n));
}
public static BigInteger factorial(BigInteger n){
    if (n==BigInteger.ZERO)
    return BigInteger.ONE;
    else
    return n.multiply(factorial(n.subtract(BigInteger.ONE)));
 }
}
