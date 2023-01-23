package datastructures2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Exc19_09SortInts {
	public static void main(String[] args){
		Scanner inp = new Scanner(System.in);
		
		System.out.print("Enter 10 integers: ");
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++){
			list.add(inp.nextInt());
		}
		sort(list);
		Collections.reverse(list);
		System.out.println("Sorted integers: " + list);
	}
		
public static <E extends Comparable <E>> void sort(ArrayList<E> list){

	Collections.sort(list);
  }
}