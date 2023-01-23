package datastructures2018;

import java.util.Scanner;

public class Exc22_05SameNSequence {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int[] count = new int[101];
		int[] mylist = new int[count.length];
		int startV = 0;
		int currV = 0;

		System.out.print("Enter a series of numbers ending with 0:");
		for (int i = 0; i < count.length; i++) {
            count[i] = input.nextInt();
            if (count[i] == 0) {
                break;
            }
        }
		for(int i = 0; i < count.length; i++) {
			if(count[i] == count[i + 1]) {
				startV++;
			} else if(currV > startV) {
				startV = currV;
				int value = count[i];
				int index = i - currV;
			}
		}
		
	}
}
