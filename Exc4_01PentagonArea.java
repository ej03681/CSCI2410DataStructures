package datastructures2018;

import java.util.Scanner;

public class Exc4_01PentagonArea {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the length from the center to a vertex: ");
		double radius = in.nextDouble();
		
		double side = 2*radius* Math.sin(Math.PI / 5);
		double area = ((5 * Math.pow(side, 2)) / (4 * Math.tan(Math.PI / 5)));
		System.out.printf("The area of the pentoagon is %4.2f" , area);
	}
}
