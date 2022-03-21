package java8lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import com.google.common.base.Predicate;

public class ChainConsumers {
	
	public static void main(String[] args) {
		List<String> strings = Arrays.asList("one", "two","three","four","five"); 
		
		List<String> result = new ArrayList<String>();
		
		Consumer<String> c1 = s->System.out.println(s);
		Consumer<String> c2 = s -> result.add(s);
		
		strings.forEach(c1.andThen(c2));
		System.out.println("size of result:"+result.size());
		
	}

}
