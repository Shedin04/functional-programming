package firstclassfunction.task2;

import firstclassfunction.task1.NoArgFunction;


public class Results {
	protected static class Person {
		private String name;
		private Integer age;

		public Person(String name, Integer age) {
			this.name = name;
			this.age = age;
		}

		@Override
		public String toString() {
			return "Person{" +
					"name='" + name + '\'' +
					", age=" + age +
					'}';
		}
	}

	protected static class DataLoader {
		public final NoArgFunction<Person> loadPerson;

		public DataLoader(Boolean isDev) {
			this.loadPerson = isDev ? this::loadPersonFake : this::loadPersonReal;
		}

		private Person loadPersonReal() {
			System.out.println("Getting a new Person");
			return new Person("Real Person", 30);
		}

		private Person loadPersonFake() {
			System.out.println("Returning a fake Person");
			return new Person("Fake Person", 100);
		}
	}

	public static void main(String[] args) {
		final Boolean IS_DEV = false;
		DataLoader dataLoader = new DataLoader(IS_DEV);
		Person result = dataLoader.loadPerson.apply();
		System.out.println(result.toString());
	}
}
