package com.mrb.java.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListExample {
	
	public static void main(String[] args) {
		List<Integer> vals = new ArrayList<>();
		
		// Adding elements to ArrayList		
		vals.add(5);
		vals.add(4);
		vals.add(7);
		vals.add(3);
		
		// Traversing ArrayList with Iterator
		Iterator<Integer> itr = vals.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next()  +" ");
		}
		System.out.println();
		
		// Removing element from ArrayList at given index
		vals.remove(0);
		
		// Traversing ArrayList with enhanced forloop
		for(Integer val: vals) {
			System.out.print(val  +" ");
		}
		System.out.println();
				
	}
}
