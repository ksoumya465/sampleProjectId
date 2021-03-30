package com.concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Vector;

public class JavaListExamples {

	public static void main(String[] args) {
		System.out.println("---- Vector allows null and duplicate values.\n It is synchronized.");
		Vector<String> v =new Vector<>();
		v.add("Xmas");
		v.add(null);
		v.add("Boy");
		v.add("Apple");
		v.add("Query");
		v.add(null);
		v.add("Xmas");
		v.add("Boys");
		v.forEach(val->System.out.println("value : "+val));
		v.remove(null);
	
		System.out.println("-After removing only one null object");
		v.forEach(System.out::println);
		int[] intArray={3,5,1,3,2};
		System.out.println("Displaying array ength : "+intArray.length);
		for(int i:intArray) {
			System.out.println(i);
		}
		System.out.println("Sorting array");
		Arrays.sort(intArray);
		System.out.println(Arrays.toString(intArray));
		
		int[] intArray2={3,5,1,3,2};
		System.out.println("Sorting Sub array");
		Arrays.sort(intArray2,0,3);
		System.out.println(Arrays.toString(intArray2));
		Integer[] intArray3={3,5,1,3,2};
		System.out.println("Array Sorting in reverse order");
		Arrays.sort(intArray3,Collections.reverseOrder());
		System.out.println(Arrays.toString(intArray3));
		System.out.println("ArrayList is more of dynamic array and better for storing and accessing data.\n It is not synchronized");
		System.out.println("ArrayList saves insertion order.\nIt allows null and duplicate values");
		ArrayList<String> al1=new ArrayList<>();
		al1.add("Xmas");
		//al1.add(null);
		al1.add("Boy");
		al1.add("Apple");
		al1.add("Query");
		//al1.add(null);
		al1.add("Xmas");
		al1.add("Boys");
		al1.forEach(System.out::println);
		
		
		System.out.println("Sorted ArrayList size() :"+al1.size());
		Collections.sort(al1);
		//System.out.println("Sort ArrayList size() :"+al1.size());
		for(int i=0;i< al1.size();i++) {
			System.out.println(al1.get(i));
		}
		System.out.println("ArrayList in reverse Order");
		Collections.sort(al1,Collections.reverseOrder());
		al1.forEach(System.out::println);
		
		System.out.println("LinkedList is more of doubly linkedlist and better for manipulating data");
		System.out.println("LinkedList preserves insertion order.\nIt allows null and duplicate values");
		LinkedList<String> ll1=new LinkedList<>();
		ll1.add("Xmas");
		ll1.add(null);
		ll1.add("Boy");
		ll1.add("Apple");
		ll1.add("Query");
		ll1.add(null);
		ll1.add("Xmas");
		ll1.add("Boys");		
		ll1.forEach(System.out::println);
		
	}

}
