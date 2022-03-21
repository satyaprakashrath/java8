package java8lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReductionOperation {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList();

		/*
		 * ======================= using empty stream =======================
		 */

		/*
		 * inline reduce function for sum
		 */
		Integer reduction = numbers.stream().reduce(0, (i1, i2) -> i1 + i2);

		System.out.println("Reduction value:" + reduction);

		/*
		 * Method reference using Integer sum function reduce function
		 * 
		 * Instead of (i1, i2) -> i1 + i2 use Integer::sum
		 */
		reduction = numbers.stream().reduce(0, Integer::sum);

		System.out.println("Reduction value:" + reduction);


		/*
		 * ======================= using non empty stream =======================
		 */
		numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

		reduction = numbers.stream().reduce(0, Integer::sum);

		System.out.println("Reduction value:" + reduction);

		/*
		 * Use Max function on reduce operation using negative value
		 * 
		 * The result is 0 which is wrong
		 * 
		 * It is because of the first parameter
		 */
		numbers = Arrays.asList(-10);
		reduction = numbers.stream().reduce(0, Integer::max);

		System.out.println("Max function: Reduction value:" + reduction);
		/*
		 * Use Optional instead of wrapper of primitive data type to
		 * avoid above issue
		 * 
		 */
		Optional<Integer> optInt = numbers.stream().reduce(Integer::max);
		
		System.out.println("Max function: Optional value:" + optInt);

	}
}
