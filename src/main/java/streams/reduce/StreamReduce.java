package streams.reduce;

import java.util.List;
import java.util.function.BinaryOperator;


public class StreamReduce {
	public static void main(String[] args) {
		Integer[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		List<Integer> data = List.of(arr);

		BinaryOperator<Integer> getSum = (acc, x) -> {
			int result = acc + x;
			System.out.println("acc: " + acc + "| x:" + x + " | result: " + result);
			return result;
		};
		System.out.println(getSum.apply(3, 4));
		Integer sum = data.stream().reduce(0, getSum); // 0 -staring argument
		System.out.println(sum);
	}
}
