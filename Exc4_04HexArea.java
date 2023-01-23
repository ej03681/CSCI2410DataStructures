package datastructures2018;

import java.util.Scanner;

public class Exc4_04HexArea {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the side: ");
		double sideLength = in.nextDouble();
		
		double area = (6 * Math.pow(sideLength, 2))/ (4 * Math.tan(Math.PI / 6));
		System.out.printf("The are of the hexagon is %4.2f", area);
	}
}
