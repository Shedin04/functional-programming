package firstclassfunction.task6;

import java.util.function.BiFunction;
import java.util.function.Function;


public class HigherOrderFunction {

	public static void main(String[] args) {
		BiFunction<Float, Float, Float> divide = (x, y) -> {
			if (y == 0) {
				System.out.println("Can't divide by zero");
				return 0f;
			}
			return x / y;
		};
		System.out.println(divide.apply(3f, 4f));

		System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*");

		BiFunction<Float, Float, Float> divideNew = (x, y) -> x / y;

		Function<BiFunction<Float, Float, Float>, BiFunction<Float, Float, Float>> secondArgNotZeroCheck = //function that receive another function
				(func) -> (x, y) -> { //function that get Float Float
					if (y == 0f) {
						System.out.println("Can't divide by zero");
						return 0f;
					}
					return func.apply(x, y);
				};

		BiFunction<Float, Float, Float> divideSafe = secondArgNotZeroCheck.apply(divideNew); // send function and get another function
		System.out.println(divideSafe.apply(4f, 0f));
	}
}
