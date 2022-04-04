package com.ps.buildStreams;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainBuildingStreams {

	public static void main(String[] args) {
		List<Integer> ints = Arrays.asList(0, 1, 2, 3, 4);
		Stream<Integer> stream1 = ints.stream();
		stream1.forEach(System.out::println);

		System.out.println();
		System.out.println("otra manera de definir stream con metodo of");
		Stream<Integer> stream2 = Stream.of(0, 1, 2, 3, 4);
		stream2.forEach(System.out::println);
		
		System.out.println();
		System.out.println("stream de strings definido con metodo generate, y con limit = 5");
		Stream<String> streamOfStrings1 = Stream.generate(() -> "one");
		streamOfStrings1.limit(5).forEach(System.out::println);
		
		System.out.println();
		System.out.println("stream de strings definido con metodo iterate, y con limit = 5");
		Stream<String> streamOfStrings2 = Stream.iterate("+", a -> a + "+");
		streamOfStrings2.limit(5).forEach(System.out::println);
		
		System.out.println();
		System.out.println("stream de enteros");
		IntStream streamOfInt = ThreadLocalRandom.current().ints();
		streamOfInt.limit(5).forEach(System.out::println);
		
	}

}
