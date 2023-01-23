package datastructures2018;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TESTb2 {
	public static void main(String[] args) throws Exception{
		java.io.File file = new java.io.File("C:\\\\Users\\\\EddyJ\\\\Scores.txt");
		Scanner input = new Scanner(file);
		
		List<Double> list = new ArrayList<Double>();
		
		while(input.hasNext()) {
			list.add(input.nextDouble());
		}
		input.close();
		
		List<Double> less = new ArrayList<Double>();
		double average;
		double min = list.get(0);
		double max = list.get(0);
		double sum = 0;
		
		for(int i = 0; i < list.size(); i++) {
			sum += list.get(i);
			if(min > list.get(i)) {
				min = list.get(i);
			}
			if(max < list.get(i)) {
				max = list.get(i);
			}
			if(list.get(i) < 100) {
				less.add(list.get(i));
			}
		}
		average = sum / list.size();
		
		System.out.println("Minimum value is " + min);
		System.out.println("Max value is " + max);
		System.out.println("There are " + list.size() + " numbers");
		System.out.println("The total is " + sum) ;
		System.out.printf("The average is %4.2f", average);
		System.out.println("\nValues less than 100 are " + less);
	
	}
}
