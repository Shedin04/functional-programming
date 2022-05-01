package streams.collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class StreamCollect {

	public static class Car {
		protected String name;
		protected float price;
		protected String type;

		public Car(String name, float price, String type) {
			this.name = name;
			this.price = price;
			this.type = type;
		}

		public String getName() {
			return name;
		}

		@Override
		public String toString() {
			return "Car{" +
					"name='" + name + '\'' +
					", price=" + price +
					", type='" + type + '\'' +
					'}';
		}
	}

	public static void main(String[] args) {
		String[] words = { "hello", "this", "is", "a", "test" };
		List<String> wordsList = List.of(words);
		String join = wordsList.stream().filter(str -> str.length() > 3).collect(Collectors.joining(" | "));
		System.out.println(join);

		Long howManyLongWords = wordsList.stream().filter(str -> str.length() > 3).collect(Collectors.counting());
		System.out.println(howManyLongWords.longValue());

		Map<Integer, List<String>> wordLengthMap = wordsList.stream().collect(Collectors.groupingBy(
				(word) -> word.length()
		));
		System.out.println(wordLengthMap);

		Map<Boolean, List<String>> isWordMoreLength = wordsList.stream().collect(Collectors.partitioningBy(
				word -> word.length() > 4
		));
		System.out.println(isWordMoreLength);

		Map<String, Integer> wordsLength = wordsList.stream().collect(Collectors.toMap(Function.identity(), String::length));
		System.out.println(wordsLength);

		System.out.println("/*/*/*/*/");
		List<Car> cars = new ArrayList<>(Arrays.asList(new Car("Tesla", 1000000, "car"),
													   new Car("Ford", 500000, "truck"),
													   new Car("Mazda", 750000, "truck"),
													   new Car("Porsche", 1500000, "car")));
		System.out.println(cars);
		Map<String, List<Car>> carsByType = cars.stream().collect(Collectors.groupingBy(car -> car.type));
		carsByType.forEach((type, car) -> System.out.println("Type: " + type + " - " + car.toString()));

		Map<String, Float> averageTypePrice = carsByType.entrySet()
				.stream()
				.collect(Collectors.toMap(
						entry -> entry.getKey(),
						entry -> entry.getValue()
								.stream().map(car -> car.price).reduce(0f, Float::sum) / entry.getValue().size()));
		System.out.println("Type | Average price");
		System.out.println(averageTypePrice);
	}
}
