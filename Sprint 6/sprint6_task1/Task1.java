package sprint6_task1;

import java.util.Arrays;
import java.util.function.Predicate;

public class Task1 {

	public static int getCount(int[] array, Predicate<Integer> predicate) {
//		int sum = 0;
//		for (int i = 0; i < array.length; i++) {
//			if (predicate.test(array[i])) {
//				sum++;
//			}
//		}
//		return sum;
		return (int) Arrays.stream(array).filter(a -> predicate.test(a)).count();
	}

}
