package java8lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class IntermediaryAndFinalStreamOperations {

	public static void main(String[] args) {
		Stream<String> strings = Stream.of("one", "two", "three","nintynine","fourtyfive", "eleven", "thirteen");

		Predicate<String> p1 = s -> s.length() >= 3;
		Predicate<String> p2 = Predicate.isEqual("two");
		Predicate<String> p3 = Predicate.isEqual("eleven");
		
		List<String> result = new ArrayList<>();
		
		/*
		 * peek and filter are both intermediary operation
		 * so the below code will not do any operation the
		 * stream.
		 * 
		 * SIZE OF RESULT = 0
		 */
		strings
				.peek(System.out::println)
				.filter(p1.and(p2).or(p3))
				.peek(result::add);
		System.out.println("Done!!");
		System.out.println("Size of result::"+result.size());
		
		/*
		 * peek and filter are both intermediary operation
		 * but forEach is a final operation
		 * so the below code will operation on the stream.
		 * 
		 * SIZE OF RESULT = 2
		 */
		strings = Stream.of("one", "two", "three","nintynine","fourtyfive", "eleven", "thirteen");
		strings
				.peek(System.out::println)
				.filter(p1.and(p2).or(p3))
				.forEach(result::add);
		System.out.println("Done!!");
		System.out.println("Size of result::"+result.size());
	}

}
