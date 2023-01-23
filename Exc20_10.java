package datastructures2018;

import java.util.PriorityQueue;

public class Exc20_10 {
public static void main(String[] args){
	PriorityQueue<String> collection = new PriorityQueue<>();
	collection.add("George");
	collection.add("Jim");
	collection.add("John");
	collection.add("Blake");
	collection.add("Kevin");
	collection.add("Michael");
	
	PriorityQueue<String> names2 = new PriorityQueue<>();
	names2.add("George");
	names2.add("Katie");
	names2.add("Kevin");
	names2.add("Michelle");
	names2.add("Ryan");
   
	PriorityQueue<String> temp = new PriorityQueue<>(collection);
	collection.addAll(names2);
	
	System.out.println("The union of the two priority queue is " + collection);
	
	PriorityQueue<String> diff = new PriorityQueue<>(collection);
	diff.removeAll(names2);
	System.out.println("The difference of the two priority queue is " + diff);
	
	
	PriorityQueue<String> inter = new PriorityQueue<>(temp);
	inter.retainAll(names2);
	System.out.println("The intersection of the two priority queue is " + inter);
	
    }
}