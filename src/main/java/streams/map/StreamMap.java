package streams.map;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


public class StreamMap {
	public static void main(String[] args) {
		Integer[] arr = { 1, 2, 3, 4 };
		List<Integer> num = List.of(arr);

		Function<Integer, Integer> xx = (x) -> x * 2;
		List<Integer> numNum = num.stream().map(xx).collect(Collectors.toList());
		System.out.println(numNum);
	}
}
