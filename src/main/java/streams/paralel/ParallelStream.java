package streams.paralel;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;


public class ParallelStream {
	public static void main(String[] args) {
		String[] words = { "hello", "this", "is", "a", "test" };
		List<String> wordsList = List.of(words);

		List<String> newWords = wordsList
				.parallelStream()
				.map(word -> {
					System.out.println("Current word: " + word);
					return word.toUpperCase(Locale.ROOT);
				})
				.map(word -> {
					System.out.println("Adding exclamation point to: " + word);
					return word + "!";
				})
				.collect(Collectors.toList());
		System.out.println(newWords);
	}
}