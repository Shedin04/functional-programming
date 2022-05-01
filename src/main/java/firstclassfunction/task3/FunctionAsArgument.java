package firstclassfunction.task3;

import java.util.function.BiFunction;


public class FunctionAsArgument {
	protected static class MyMath {
		public static Integer add(Integer x, Integer y) {
			return x + y;
		}

		public static Integer subtract(Integer x, Integer y) {
			return x - y;
		}

		public static Integer combination(BiFunction<Integer, Integer, Integer> combineFunction) {
			return combineFunction.apply(2, 3);
		}
	}

	public static void main(String[] args) {
		System.out.println(MyMath.combination(MyMath::add));
		System.out.println(MyMath.combination(MyMath::subtract));
		System.out.println(MyMath.combination((x, y) -> 2 * x + 3 * y));
	}
}
