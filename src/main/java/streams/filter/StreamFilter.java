package streams.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamFilter {

	public static void main(String[] args) {
		Integer[] arr = { 1, 2, 3, 4 };
		List<Integer> num = List.of(arr);

		Predicate<Integer> isEven = (x) -> x % 2 == 0;

		List<Integer> evens = num.stream().filter(isEven).collect(Collectors.toList());
		System.out.println(evens);

		String[] words = { "hello", "this", "is", "a", "test" };
		List<String> wordsList = List.of(words);
		Predicate<String> moreThanFour = (str) -> str.length() >= 4;
		List<String> longerWords = wordsList.stream().filter(moreThanFour).collect(Collectors.toList());
		System.out.println(longerWords);

		Function<Integer, Predicate<String>> moreThanNumberLength = (minLength) -> (str) -> str.length() > minLength;
		List<String> longer1Words = wordsList.stream().filter(moreThanNumberLength.apply(1)).collect(Collectors.toList());
		System.out.println(longer1Words);
	}
}
