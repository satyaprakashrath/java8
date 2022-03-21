package java8lambda;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java8lambda.model.Person;

public class CollectorsExample {

	public static void main(String[] args) {

		List<Person> persons = new ArrayList<>();
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(CollectorsExample.class.getResourceAsStream("people.txt")));

		Stream<String> lines = reader.lines();

		lines.map(line -> {
			String[] s = line.split(" ");
			Person p = new Person(s[0], Integer.valueOf(s[1]));
			persons.add(p);
			return p;
		}).forEach(System.out::println);

		List<String> data = persons.stream().filter(p -> p.getAge() > 20).map(Person::getName)
				.collect(Collectors.toList());

		System.out.println(data);

		Map<Integer, List<Person>> data2 = persons.stream().filter(p -> p.getAge() > 20)
				.collect(Collectors.groupingBy(Person::getAge));

		System.out.println(data2);

		/*
		 * Adding downstream collector instead of list of people group age with number
		 * of people
		 */
		Map<Integer, Long> data3 = persons.stream().filter(p -> p.getAge() > 20)
				.collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));

		System.out.println(data3);

		/*
		 * Adding downstream collector instead of list of people, group age with name of
		 * people
		 */
		Map<Integer, List<String>> data4 = persons.stream().filter(p -> p.getAge() > 20).collect(
				Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toList())));

		System.out.println(data4);
		
		/*
		 * Adding downstream collector instead of list of people, group age with name of
		 * people in one string separated by comma
		 */
		Map<Integer, String> data5 = persons.stream().filter(p -> p.getAge() > 20).collect(
				Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.joining(","))));

		System.out.println(data5);
		

	}
	

}
