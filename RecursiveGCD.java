/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures2018;

import java.util.Scanner;


public class RecursiveGCD {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int x = input.nextInt();
        System.out.println("Enter the second number: ");
        int y = input.nextInt();
        System.out.println("The GCD of " + x +" and " + y + " is " + gcd(x,y));
    }
    public static int gcd(int x, int y){
    if(y != 0)
    return gcd(y, x % y);
    else 
    return x;
       }
}