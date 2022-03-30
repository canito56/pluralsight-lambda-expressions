package com.ps.functionalInterface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.ps.comparator.Person;

public class MainFunctionalInterface {
	
	private static String s;
	
	public static void main(String[] args) {
		s = "Hola viejo!";
		
		Consumer<String> printer1 = s -> System.out.println(s);
		Consumer<String> printer2 = System.out::println;
		printer1.accept("printer1: " + s);
		printer2.accept("printer2: " + s);
		
		Supplier<Person> personSupplier = () -> new Person("Pedro", "Picapiedra", 45);
		System.out.println(personSupplier.get().getFirstName() + " " + personSupplier.get().getLastName() + 
				           ", edad " + personSupplier.get().getAge() + " años");
	
		Person person = new Person("Juan", "Garcia", 25);
		Function<Person, Integer> ageMapper = p -> p.getAge();
		System.out.println("La edad de " + person.getFirstName() + " " + person.getLastName() + 
				" es " + ageMapper.apply(person));
				
		Predicate<String> p1 = s -> s.length() < 20;
		System.out.println("Hello World tiene menos de 20 caracteres? " + p1.test("Hello World"));
		Predicate<String> p2 = s -> s.length() > 5;
		System.out.println("Hello World tiene mas de 5 caracteres? " + p1.test("Hello World"));		
		Predicate<String> p3 = p1.and(p2);
		System.out.println("p3 for Yes: " + p3.test("Yes"));
		System.out.println("p3 for Good Morning: " + p3.test("Good Morning"));
		System.out.println("p3 for Good Morning Gentlemen: " + p3.test("Good Morning Gentlemen"));
		Predicate<String> p4 = p1.or(p2);
		System.out.println("p4 for Yes: " + p4.test("Yes"));
		System.out.println("p4 for Good Morning: " + p4.test("Good Morning"));
		System.out.println("p4 for Good Morning Gentlemen: " + p4.test("Good Morning Gentlemen"));
		Predicate<String> p5 = Predicate.isEqual("Yes");
		System.out.println("p5 for Yes: " + p5.test("Yes"));
		System.out.println("p5 for No: " + p5.test("No"));

/*		
		Map<City, List<Person>> map1 = new HashMap<>();
		Map<City, List<Person>> map2 = new HashMap<>();
		
		map2.forEach((Key, value) -> map1.merge(Key, value, (existingPeaple, newPeople) -> {
			existingPeople.addAll(newPeople);
			return existingPeople;
		}));
*/		
	}

}
