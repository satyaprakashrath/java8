package java8lambda;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FirstPredicate {

	public static void main(String[] args) {
		
		Stream<String> strings = Stream.of("one", "two", "three","nintynine","fourtyfive", "eleven", "thirteen");

		Predicate<String> p1 = s -> s.length() > 3;
		Consumer<String> c1 = System.out::println;
		strings.filter(p1).forEach(c1);
		

	}

}
