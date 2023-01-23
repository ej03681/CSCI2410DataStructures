package datastructures2018;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Exc22_01MaxConChar {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter string: ");
		String list = input.nextLine();

		LinkedList<Character> max = new LinkedList<>();
		HashSet<Character> s = new HashSet<>();

		for (int i = 0; i < list.length(); i++) {
			if (s.contains(list.charAt(i))) {
				s.clear();
			}
			s.add(list.charAt(i));

			if (s.size() > max.size()) {
				max.clear();
				max.addAll(s);
			}
		}
		PriorityQueue<Character> sort = new PriorityQueue<>(max);
		while (!sort.isEmpty()) {
			System.out.print(sort.poll() + " ");
		}

	}
}
