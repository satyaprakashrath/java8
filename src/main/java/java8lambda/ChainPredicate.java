package java8lambda;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ChainPredicate {

	public static void main(String[] args) {
		
		Stream<String> strings = Stream.of("one", "two", "three","nintynine","fourtyfive", "eleven", "thirteen");

		Predicate<String> p1 = s -> s.length() > 3;
		Predicate<String> p2 = s -> s.contains("ve");
		Predicate<String> p3 = Predicate.isEqual("eleven");
		Consumer<String> c1 = System.out::println;
		/*
		 * And condtion
		 */
		System.out.println("----------AND-------------");
		strings.filter(p1.and(p2)).forEach(c1);
		
		/*
		 * Or conditions
		 */
		strings = Stream.of("one", "two", "three","nintynine","fourtyfive", "eleven", "thirteen");
		System.out.println("----------OR-------------");
		strings.filter(p1.or(p2).and(p3)).forEach(c1);
		

	}

}
