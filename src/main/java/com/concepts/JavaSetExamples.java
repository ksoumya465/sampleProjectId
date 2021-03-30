package com.concepts;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class JavaSetExamples {

	public static void main(String[] args) {
		System.out.println("-----HashSet does not allow duplicates but allows null value and does not return in any order");
		Set<String> hashSet=new HashSet<String>();
		hashSet.add("Dog");
		hashSet.add("Ball");
		hashSet.add("Egg");
		hashSet.add("Apple");
		hashSet.add("Egg");
		hashSet.add(null);
		hashSet.add("Fan");
		hashSet.add("Cat");
		hashSet.add(null);
		hashSet.forEach(value ->
		System.out.println("value "+value));
		
		System.out.println("-----TreeSet does not allow neither duplicates nor null value .\n It returns in sorted order");
		Set<String> treeSet=new TreeSet<String>();
		treeSet.add("Dog");
		treeSet.add("Ball");
		treeSet.add("Egg");
		treeSet.add("Apple");
		treeSet.add("Egg");
		treeSet.add("Fan");
		treeSet.add("Cat");
		treeSet.forEach(System.out::println);
		
		System.out.println("-----LinkedHashSet does not allow duplicates but allows null value .\n It preserves insertion order");
		Set<String> linkedHashSet=new LinkedHashSet<String>();
		linkedHashSet.add("Dog");
		linkedHashSet.add(null);
		linkedHashSet.add("Ball");
		linkedHashSet.add("Egg");
		linkedHashSet.add("Apple");
		linkedHashSet.add("Egg");
		linkedHashSet.add("Fan");
		linkedHashSet.add("Cat");
		linkedHashSet.add(null);
		for(String value:linkedHashSet)
			System.out.println(value);
		
		
	}

}
