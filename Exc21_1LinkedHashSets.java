package datastructures2018;

import java.util.LinkedHashSet;

public class Exc21_1LinkedHashSets {
public static void main(String[] args){
	LinkedHashSet<String> names1 = new LinkedHashSet<>();
	names1.add("George");
	names1.add("Jim");
	names1.add("John");
	names1.add("Blake");
	names1.add("Kevin");
	names1.add("Michael");
	
	LinkedHashSet<String> names2 = new LinkedHashSet<>();
	names2.add("George");
	names2.add("Katie");
	names2.add("Kevin");
	names2.add("Michelle");
	names2.add("Ryan");
	
	LinkedHashSet<String> temp = new LinkedHashSet<>(names1);

	names1.addAll(names2);
	
	System.out.println("The union of the two sets is " + names1);

	names1.removeAll(names2);
	System.out.println("The difference of the two sets is " + names1);
	
	temp.retainAll(names2);
	System.out.println("The intersection of the two sets is " + temp);
	
}
}
