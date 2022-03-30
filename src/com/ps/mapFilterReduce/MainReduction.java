package com.ps.mapFilterReduce;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class MainReduction {

	public static void main(String[] args) {
		
		List<Integer> ints = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		List<Integer> ints1 = Arrays.asList(0, 1, 2, 3, 4);
		List<Integer> ints2 = Arrays.asList(5, 6, 7, 8, 9);
		
		BinaryOperator<Integer> op = (i1, i2) -> i1 + i2;
//		BinaryOperator<Integer> op = (i1, i2) -> Integer.max(i1, i2);
		
		int reduction1 = ints.stream().reduce(0, op);
		
		System.out.println("Positivos");
		System.out.println("Reduction on ints : " + reduction1);
		
		int reduction2 = ints1.stream().reduce(0, op);
		int reduction3 = ints2.stream().reduce(0, op);
		
		int reduction4 = Arrays.asList(reduction2, reduction3).stream().reduce(0, op);
		
		System.out.println("Reduction on ints : " + reduction4);
		
		ints = Arrays.asList(0, 1, 2, 3, 4, -1, -2, -3, -4);
		ints1 = Arrays.asList(0, 1, 2, 3, 4);
		ints2 = Arrays.asList(-1, -2, -3, -4);
		
//		op = (i1, i2) -> i1 + i2;
		op = (i1, i2) -> Integer.max(i1, i2);
		
		reduction1 = ints.stream().reduce(0, op);
		
		System.out.println();
		System.out.println("Positivos y Negativos");
		System.out.println("Reduction on ints : " + reduction1);
		
		reduction2 = ints1.stream().reduce(0, op);
		reduction3 = ints2.stream().reduce(0, op);
		
		reduction4 = Arrays.asList(reduction2, reduction3).stream().reduce(0, op);
		
		System.out.println("Reduction on ints : " + reduction4);

		ints = Arrays.asList(-1, -2, -3, -4);
		ints1 = Arrays.asList(-1, -2, -3, -4);
		ints2 = Arrays.asList(-5, -6, -7, -8);

		//		op = (i1, i2) -> i1 + i2;
		op = (i1, i2) -> Integer.max(i1, i2);
		
		reduction1 = ints.stream().reduce(-1, op);
		
		System.out.println();
		System.out.println("Negativos");
		System.out.println("Reduction on ints : " + reduction1);
		
		reduction2 = ints1.stream().reduce(-1, op);
		reduction3 = ints2.stream().reduce(-1, op);
		
		reduction4 = Arrays.asList(reduction2, reduction3).stream().reduce(-1, op);
		
		System.out.println("Reduction on ints : " + reduction4);

	}

}
