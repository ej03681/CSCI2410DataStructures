package datastructures2018;

import java.util.Scanner;

/**
 *
 * @author EddyJ
 */
public class InClassJan24 {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
    double[] v = new double[5];
    for (int i = 0; i < 5; i++) 
      v[i] = input.nextDouble();
    int n = 0;
    while (n < 5) {
    	System.out.print(v[n] + " ");
     n++;
    }
    for(int i = v.length - 1; i > 0; i-- ) {
    	System.out.print(v[i] + " ");
    }
    
    
	}
    
}
