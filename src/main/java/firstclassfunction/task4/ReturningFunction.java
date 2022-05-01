package firstclassfunction.task4;

import firstclassfunction.task1.NoArgFunction;

import java.util.function.Function;


public class ReturningFunction {

	protected static class MyMath {
		public static Integer timesTwo(Integer x) {
			return x * 2;
		}

		public static Integer timesThree(Integer x) {
			return x * 3;
		}

		public static Integer timesFour(Integer x) {
			return x * 4;
		}

		public static Function<Integer, Integer> createMultiFunction(Integer y) {
			return (Integer x) -> x * y; // return a function
		}
	}

	public static void main(String[] args) {
		NoArgFunction<NoArgFunction<String>> createPrinter = () -> () -> "Hello"; //function that returns function that return String

		NoArgFunction<String> greeter = createPrinter.apply();

		System.out.println(greeter.apply());

		Function<Integer, Integer> timesTwo = MyMath.createMultiFunction(2); //receive a function
		Function<Integer, Integer> timesThree = MyMath.createMultiFunction(3);
		Function<Integer, Integer> timesFour = MyMath.createMultiFunction(4);

		System.out.println(timesTwo.apply(5));
		System.out.println(timesThree.apply(5));
		System.out.println(timesFour.apply(5));
	}
}
