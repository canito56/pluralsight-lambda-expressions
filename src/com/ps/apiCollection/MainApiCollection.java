package com.ps.apiCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.ps.comparator.Person;

public class MainApiCollection {

	public static void main(String[] args) {
		Person p1 = new Person("Alice", "Cooper", 23);
		Person p2 = new Person("Brain", "Romero", 56);
		Person p3 = new Person("Chelsea", "Red", 46);
		Person p4 = new Person("David", "Singerman", 28);
		Person p5 = new Person("Erika", "Ponce", 24);
		Person p6 = new Person("Francisco", "Garcia", 26);
		
		List<Person> people = new ArrayList<Person>(Arrays.asList(p1, p2, p3, p4, p5, p6));
		
		people.forEach(person -> System.out.println(person));
		
		people.removeIf(person -> person.getAge() > 50);
		System.out.println();
		System.out.println("Personas despues del remove");
		people.forEach(System.out::println);

		System.out.println();
		System.out.println("Poner todos los nombres con mayusculas y ordenarlos por edad");
		people.replaceAll(person -> new Person(person.getFirstName().toUpperCase(), 
				person.getLastName().toUpperCase(), person.getAge()));
		people.sort(Comparator.comparing(Person::getAge));
		people.forEach(System.out::println);

		System.out.println();
		System.out.println("ordenarlos por edad descendente");
		people.sort(Comparator.comparing(Person::getAge).reversed());
		people.forEach(System.out::println);

		
	}

}
