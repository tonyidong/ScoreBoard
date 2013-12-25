package TurningPoint;

import java.util.*;

public class hashS {
	
	public static void main(String[] args){
		HashSet<Integer> phones = new HashSet<Integer>();
		phones.add(123123);
		phones.add(123123);
		phones.add(2133636);
		phones.remove(123123);
		System.out.println(phones);
		
		HashMap<String, Integer> whatever = new HashMap<String, Integer>();
		whatever.put("name1", 123123123);
		whatever.put("name2", 123423123);
		whatever.put("name3", 1231267623);
		System.out.println(whatever);
		System.out.println(whatever.get("name2"));
		
		HashMap<String, HashSet<String>> people = new HashMap<String, HashSet<String>>();
		HashSet<String> friends = new HashSet<String>();
		friends.add("Alice");
		friends.add("Emily");
		people.put("Tony", friends);
		people.put("Rex", friends);
		System.out.println(people);
		
		
		System.out.println((2*4<10) + "whatever");
	}

}
