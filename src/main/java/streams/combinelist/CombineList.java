package streams.combinelist;

import java.util.List;


public class CombineList {
	public static void main(String[] args) {
		Integer[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		List<Integer> nums = List.of(arr);

		Integer total = nums.stream().filter(num -> num % 2 == 0).map(num -> num * 2).reduce(0, Integer::sum);
		System.out.println(total);

		Integer total2 = ((Long) nums.stream().filter(num -> num % 2 == 0).count()).intValue();
		System.out.println(total2);
	}
}