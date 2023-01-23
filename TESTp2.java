package datastructures2018;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TESTp2 {
	public static void main(String[] args) {
		
		Integer[] list = {12, 1, 2, 1, 4, 9, 7, 8, 4, 6, 8};
		List<Integer> list1 = new ArrayList<Integer>();
		for(int i = 0; i < list.length; i++) {
			list1.add(list[i]);
		}
		System.out.print("Dictionary of list is " + getMap(list1));
		
	}
	
	public static Map <Integer, Integer> getMap(List <Integer> list){
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		int count = 0;
		
		for (int i = 0; i < list.size(); i++) {
			count = 0;
			for (int j = 0; j < list.size(); j++) {
				if (list.get(i) == list.get(j)) {
					count++;
				}
			}
			map.put(list.get(i), count);
		}
		return map;
	}
}
