package datastructures2018;

import java.util.Scanner;

public class Exc04_11DecimalToHex {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a decimal value (0 to 15): ");
		
		String temp = in.next();
		temp.toUpperCase();
		
		int uni = 0;
		if(temp.length() > 2) {
			System.out.print("Must enter decimal value (0 to 15)");
			System.exit(0);
		} else if (temp.length() > 1) {
			uni = temp.charAt(0) + temp.charAt(1) - 87;
		} else {
			uni = temp.charAt(0) - 48;
		} 
		char ch = 0;
		if(uni == 10) {
			ch = 'A';
		} else if (uni == 11) {
			ch = 'B';
		} else if (uni == 12) {
			ch = 'C';
		} else if (uni == 13) {
			ch = 'D';
		} else if (uni == 14) {
			ch = 'F';
		} else if (uni > 14 ) {
			System.out.print("Wrong input");
			System.exit(0);
		}
		
		if (uni > 9) {
			System.out.print("The hex value is " + ch);
		} else {
			System.out.print("The hex value is " + uni);
		}
	}
}
