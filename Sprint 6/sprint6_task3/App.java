package sprint6_task3;

import java.util.function.BinaryOperator;
import java.util.ArrayList;
import java.util.List;

public class App {

	static BinaryOperator<String> greetingOperator = (parametr1, parametr2) -> "Hello " + parametr1 + " " + parametr2
			+ "!!!";

	public static List<String> createGreetings(List<Person> people, BinaryOperator<String> greetingOperator) {
		List<String> result = new ArrayList<>();
		for (Person item : people) {
			result.add(greetingOperator.apply(item.name, item.surname));
		}
		return result;

	}
}
