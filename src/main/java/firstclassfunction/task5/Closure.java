package firstclassfunction.task5;

import firstclassfunction.task1.NoArgFunction;


public class Closure {

	public static void main(String[] args) {
		NoArgFunction<String> createGreeter = () -> "Name";
		System.out.println(createGreeter.apply());

		NoArgFunction<NoArgFunction<String>> createGreeterTwo = () -> {
			String name = "TestName";
			return () -> "Hello, " + name;
		};
		NoArgFunction<String> greeter = createGreeterTwo.apply(); //in this moment we have only access for function
		System.out.println(greeter.apply());
	}
}
