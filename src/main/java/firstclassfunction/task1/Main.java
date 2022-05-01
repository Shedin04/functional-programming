package firstclassfunction.task1;

import java.util.function.BiFunction;
import java.util.function.Function;


public class Main {

	public static class Functions {
		protected static Integer triple(Integer x) {
			return x * 3;
		}
	}

	public static void main(String[] args) {
		Function<Integer, Integer> firstFunction = Functions::triple;
		Integer result = firstFunction.apply(5);
		System.out.println(result);

		Function<Integer, Integer> absoluteValue = (x) -> x < 0 ? -1 : 1;
		System.out.println(absoluteValue.apply(100));

		BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
		System.out.println(add.apply(1, 2));

		TriFunction<Integer, Integer, Integer, Integer> addThree = (x, y, z) -> x + y + z;
		System.out.println(addThree.apply(1, 2, 3));

		NoArgFunction<String> sayTest = () -> "Test";
		System.out.println(sayTest.apply());
	}
}