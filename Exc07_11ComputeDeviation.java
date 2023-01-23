package datastructures2018;

import java.util.Scanner;

public class Exc07_11ComputeDeviation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double[] list = new double[10];

		System.out.print("Enter 10 numbers: ");
		for(int i = 0; i < list.length; i++) {
			list[i] = in.nextDouble();
		}
		System.out.println("The mean is " + mean(list));
		System.out.println("The standard devation is " + deviation(list));		
	}
	
	public static double deviation(double[] x) {
		double square = 0;
		for (int i = 0; i < x.length; i++) {
			square += Math.pow((x[i] - mean(x)), 2);
		}
		double diff = square / (x.length - 1);
		
		return Math.pow(diff, .5);
	}
	
	public static double mean(double[] x) {
		double sum = 0;
		for(int i = 0; i < x.length; i++) {
			sum += x[i];
		}
		return sum / x.length;
	}
}
