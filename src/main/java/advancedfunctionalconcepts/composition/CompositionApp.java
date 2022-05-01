package advancedfunctionalconcepts.composition;

import streams.collect.StreamCollect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;


public class CompositionApp {
	public static void main(String[] args) {
		Function<Integer, Integer> timesTwo = x -> x * 2;
		Function<Integer, Integer> minusOne = x -> x - 1;

		Function<Integer, Integer> timesTwoMinusOne = minusOne.compose(timesTwo);
		Function<Integer, Integer> minusOneTimesTwo = minusOne.andThen(timesTwo);
		System.out.println(timesTwoMinusOne.apply(10));
		System.out.println(minusOneTimesTwo.apply(10));

		List<StreamCollect.Car> cars = new ArrayList<>(Arrays.asList(new StreamCollect.Car("Tesla", 1000000, "car"),
																	 new StreamCollect.Car("Ford", 500000, "truck"),
																	 new StreamCollect.Car("Mazda", 750000, "truck"),
																	 new StreamCollect.Car("Porsche", 1500000, "car")));
		Function<StreamCollect.Car, String> getName = StreamCollect.Car::getName;
		Function<String, String> reverse = str -> new StringBuilder(str).reverse().toString();
		Function<String, String> upperCase = str -> str.toUpperCase(Locale.ROOT);
		Function<StreamCollect.Car, String> getReversedUppercaseName = getName.andThen(reverse).andThen(upperCase);

		List<String> results = cars.stream().map(getReversedUppercaseName).collect(Collectors.toList());
		System.out.println(results);
	}
}