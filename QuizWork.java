package datastructures2018;

import java.util.Scanner;

/**
 *
 * @author EddyJ
 */
public class QuizWork {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);      
        System.out.println("Enter a number to print asterisk triangle: ");
        int n = input.nextInt();
        printTriangle(n);
    }
    public static String makeStars(int n){
        if (n <= 0)
            return "";
        return "*" + makeStars(n-1);
    }
    public static void printTriangle(int n){
        if (n ==0)
            return;
        System.out.println(makeStars(n));
        printTriangle(n-1);
    }
}
