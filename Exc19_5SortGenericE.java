package datastructures2018;

import java.util.Scanner;

public class Exc19_5SortGenericE {
	public static void main(String[] args){
		Scanner inp = new Scanner(System.in);
		
		System.out.print("Enter 10 integers: ");
		Integer[] list = new Integer[10];
		for(int i = 0; i < list.length; i++){
			list[i] = inp.nextInt();
		}
		System.out.println("The max number is " + max(list) );
	}
		
public static <E extends Comparable <E>> E max(E[] list){

	E max = list[0];
 
	for(int i = 0; i < list.length; i++){
	 E element = list[i];

	 if(element.compareTo(max) > 0){
		 max = element;
	 }	
 }
	return max; 
}
	}