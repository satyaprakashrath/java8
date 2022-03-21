package java8lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class MapAndFlatMap {
	
	public static void main(String[] args) {
		List<Integer> l1 = Arrays.asList(1,2,3,4,5,6,7);
		List<Integer> l2 = Arrays.asList(3,4,5);
		List<Integer> l3 = Arrays.asList(6,7);
		
		List<List<Integer>> list = Arrays.asList(l1,l2,l3);
		
		/*
		 * Example of Map with a embedded function
		 */
		list.stream()
					.map(l -> l.size())
					.forEach(System.out::println);
		
		/*
		 * Function returning stream
		 * 
		 */
		Function<List<Integer>, Stream<Integer>> mapperFunction = l -> l.stream();
		/*
		 * map operation will return stream of streams
		 * 
		 */
		list.stream()
					.map(mapperFunction)
					.forEach(System.out::println);
		
		/*
		 * flatmap operation will return flaten the streams and return one stream having all integers
		 * 
		 */
		list.stream()
					.flatMap(mapperFunction)
					.forEach(System.out::println);
	}

}
