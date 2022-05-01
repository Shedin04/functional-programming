package streams.collect;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class StreamCollect {
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
	}
}
