package com.concepts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class JavaMapConcepts {
	
	public static void main(String[] args) {
		Map<String,String> map1=new HashMap<String,String>();
		map1.put(null,"abc");
		map1.put("Key1","Value1");
		map1.put("Key2","Value2");
		map1.put("Key3","Value3");
		map1.put("Key4",null);
		map1.put("Key5",null);
		map1.put("Key6","Value6");
		map1.put("Key7","Value9");
		map1.put("Key8",null);
		map1.put("Key9","Value9");
		map1.put("Key10","Value");
		map1.put("Key10","Value10");
		map1.put(null,null);
		
		System.out.println("Map allows only unique keys and 'null' also can be a key but values are not unique");

		System.out.println("----------- 1 Iterating Over Map throgh entrySet()----------------");
		for(Map.Entry<String,String> entry : map1.entrySet()) {
			System.out.println("Key : "+entry.getKey()+" , Value : "+entry.getValue());
		}

		Map<Integer,String> map2 = new HashMap<>();	
		map2.put(null,null);
		map2.put(null,"0");
		map2.put(1,"Value1");
		map2.put(2,"Value");
		map2.put(2,"Value2");
		map2.put(3,null);
		map2.put(4,null);
		System.out.println("--------2 Iterating over forEach lambda expression-------------");
		map2.forEach((K,V) ->
		System.out.println("Key :"+K+" , Value :"+V));
		
		System.out.println("--------------3 Using Iterators-------------");
		Map<Integer,String> map3 = new HashMap<>();	
		map3.put(null,null);
		map3.put(null,"0");
		map3.put(1,"Value1");
		map3.put(2,"Value");
		map3.put(2,"Value2");
		map3.put(3,null);
		map3.put(4,null);
		Iterator<Map.Entry<Integer,String>>itr = map3.entrySet().iterator();
		while(itr.hasNext()) {
			Map.Entry<Integer,String> entry=itr.next();
			System.out.println("Key :"+entry.getKey()+" , Value :"+entry.getValue());
		}
		System.out.println("--------------4 Iterating only Keys and values seperately-------------");
		for(Integer key : map3.keySet()) {
			System.out.println("Key :"+key);
		}
		for(String value:map3.values()) {
			System.out.println("value :"+value);
		}
		System.out.println("--------------5 Iterating only Keys and getting values using keys-------------");	
		for(Integer key : map3.keySet()) {
			String value = map3.get(key);
			System.out.println("Key :"+key+" , value :"+value);
		}	
		
		System.out.println("---------------Important methods in HashMap : clear() removes all entries in Map---------------");
		//map3.clear();
		System.out.println("map3.containsKey(1) : "+map3.containsKey(1));
		System.out.println("map3.containsKey(null) : "+map3.containsKey(null));
		System.out.println("map3.containsKey(10) : "+map3.containsKey(10));
		System.out.println("map3.containsValue(null) : "+map3.containsValue(null));
		System.out.println("map3.containsValue(value1) : "+map3.containsValue("value1"));
		System.out.println("map3.containsValue(Value1) : "+map3.containsValue("Value1"));
		System.out.println("map3.containsValue(0) : "+map3.containsValue("0"));
		map3.replace(1,"1");
		Iterator<Map.Entry<Integer,String>>itr1 = map3.entrySet().iterator();
		while(itr1.hasNext()) {
			Map.Entry<Integer,String> entry=itr1.next();
			System.out.println("Key :"+entry.getKey()+" , Value :"+entry.getValue());
		}
		
		System.out.println("----- How to retrieve in an order using Map or to sort the key value pairs? \n Use TreeMap . It does not allow null key values , keys are unique and ordered where as values are not unique but null values are allowed----");
		Map<String,String> unorderedMap = new TreeMap<>();
		unorderedMap.put("Key6","Value6");
		unorderedMap.put("Key7","Value9");
		unorderedMap.put("Key10","Value");
		unorderedMap.put("Key8",null);
		unorderedMap.put("Key1","Value10");
		unorderedMap.put("Key2","Value2");
		unorderedMap.put("Key4",null);
		unorderedMap.put("Key5",null);
		unorderedMap.put("Key9","Value9");
		unorderedMap.put("Key10","Value10");
		unorderedMap.put("Key3","Value3");
		
		unorderedMap.forEach((K,V)->
		System.out.println("K :"+K+" , V :"+V)
				);
		
		System.out.println("----- Which map do we need to use with No null keys and No null values and Thread safe map ? \n Use HashTable . It does not allow niether null key nor null values and keys are unique but keys are unordered. values are not unique----");
		Map<Integer,Integer>hashTable1 = new Hashtable<Integer,Integer>();
		hashTable1.put(10,10);
		hashTable1.put(5,5);
		hashTable1.put(0,0);
		hashTable1.put(1,500);
		
		//hashTable1.put(null,200);
		//hashTable1.put(2,null);
		hashTable1.put(1,1);
		hashTable1.put(13,300);
		//hashTable1.put(0,null);
		hashTable1.put(6,5);
		hashTable1.forEach((K,V) ->
		System.out.println("K :"+K+" , V :"+V));
		
		System.out.println("How to order Hashtable ? There are ways to sort Hashtable using Collections.list and Collections.sort.\n however best thing to do is use LinkedHashMap or TreeMap.");
		System.out.println("To maintain insertion order use LinkedHashMap");
		LinkedHashMap<Integer,Integer> linkHashMap1=new LinkedHashMap<>();
		linkHashMap1.put(10,10);
		linkHashMap1.put(5,5);
		linkHashMap1.put(0,0);
		linkHashMap1.put(1,500);
		//linkHashMap1.put(null,200);
		linkHashMap1.put(2,null);
		linkHashMap1.put(1,1);
		linkHashMap1.put(13,300);
		linkHashMap1.put(0,null);
		linkHashMap1.put(6,5);		
		linkHashMap1.forEach((K,V)->
		System.out.println("K :"+K+" , V :"+V));
		System.out.println("-----Collections.sort");
		List<Integer> al1=new ArrayList<>(linkHashMap1.keySet());
		List<Integer> al2=new ArrayList<>(linkHashMap1.values());
		System.out.println("Key list Before sorting :"+al1);
		Collections.sort(al1); //if there are null throws exception

		System.out.println("Key list after sorting :"+al1);
		System.out.println("Value list before starting :"+al2);
		//Collections.sort(al2);
		//System.out.println("Value list after sorting :"+al2);
		
		System.out.println("removeIf() to remove all null values from Map ");
		linkHashMap1.values().removeIf(value->value==null);
		
		linkHashMap1.forEach((K,V)->
		System.out.println("K :"+K+" , V :"+V));
		
		LinkedHashMap<Integer,Integer> linkHashMap2=new LinkedHashMap<>();
		linkHashMap2.put(10,10);
		linkHashMap2.put(5,5);
		linkHashMap2.put(0,0);
		linkHashMap2.put(1,500);
		linkHashMap2.put(null,200);
		linkHashMap2.put(2,null);
		linkHashMap2.put(1,1);
		linkHashMap2.put(13,300);
		linkHashMap2.put(0,null);
		linkHashMap2.put(6,5);	
		
		LinkedHashMap<Integer,Integer> linkHashMap3=new LinkedHashMap<>();
		linkHashMap3.put(10,10);
		linkHashMap3.put(6,6);
		linkHashMap3.put(0,0);
		linkHashMap3.put(1,500);
		linkHashMap3.put(0,null);
		linkHashMap3.put(null,200);
		linkHashMap3.put(123,123);
		System.out.println("-----");
		linkHashMap2.forEach((K,V)->
		System.out.println("K :"+K+" , V :"+V));
		System.out.println("After removeAll()");
		linkHashMap2.keySet().removeAll(linkHashMap3.keySet());
		
		linkHashMap2.forEach((K,V)->
		System.out.println("K :"+K+" , V :"+V));
		
		System.out.println("retailAll()");
		linkHashMap2.keySet().retainAll(linkHashMap3.keySet());
		
		System.out.println("--------------------");

		
	}

}
