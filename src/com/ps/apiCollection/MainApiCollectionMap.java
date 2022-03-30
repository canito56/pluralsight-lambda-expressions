package com.ps.apiCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ps.comparator.Person;

public class MainApiCollectionMap {

	public static void main(String[] args) {
		Person p1 = new Person("Alice", "Cooper", 23);
		Person p2 = new Person("Brain", "Romero", 56);
		Person p3 = new Person("Chelsea", "Red", 46);
		Person p4 = new Person("David", "Singerman", 28);
		Person p5 = new Person("Erika", "Ponce", 24);
		Person p6 = new Person("Francisco", "Garcia", 26);
		
		City newYork = new City("New York");
		City shanghai = new City("Shanghai");
		City paris = new City("Paris");
		
		Map<City, List<Person>> map = new HashMap<City, List<Person>>();
		
		map.putIfAbsent(paris, new ArrayList<Person>());
		map.get(paris).add(p1);

		map.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p2);
		map.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p3);

		// Collections.emptyList() sirve para q no devuelva null si la lista esta vacia
		System.out.println("People from Paris: " + map.getOrDefault(paris, Collections.emptyList()));
		System.out.println("People from New York: " + map.getOrDefault(newYork, Collections.emptyList()));

		Map<City, List<Person>> map1 = new HashMap<City, List<Person>>();
		map1.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p1);
		map1.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p2);
		map1.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p3);
		System.out.println();
		System.out.println("Map 1");
		map1.forEach((city, people) -> System.out.println(city + " : " + people));

		Map<City, List<Person>> map2 = new HashMap<City, List<Person>>();
		map2.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p4);
		map2.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p5);
		map2.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p6);
		System.out.println();
		System.out.println("Map 2");
		map2.forEach((city, people) -> System.out.println(city + " : " + people));
		
		map2.forEach((city, people) -> {
			map1.merge(paris, people, (peopleFromMap1, peopleFromMap2) -> {
				peopleFromMap1.addAll(peopleFromMap2);
				return peopleFromMap1;
			});
		});
		
		System.out.println();
		System.out.println("Merged Map 1");
		map1.forEach((city, people) -> System.out.println(city + " : " + people));
	}

}
