	package datastructures2018;

import java.util.Scanner;

public class Exc22_03PatternMatch {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter a string s1: ");
		String s1 = input.nextLine();
		System.out.print("Enter a string s2: ");
		String s2 = input.nextLine();

		int index = 0;
		int count = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == s2.charAt(0) && count == 0) {
				index = i;
				count++;
			} else if (s1.charAt(i) == s2.charAt(count)) {
				count++;
			} else {
				count = 0;
				index = -1;
			}
			if (count == s2.length())
				break;
		}
		if (index > 1)
			System.out.println("Matched at index " + index);
		else
			System.out.println("Not a substring");

	}
}
