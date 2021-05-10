package sprint4_task5;

public class ArrayUtil2 {
	static <T extends Number> double averageValue(Array<T> arr) {
		double sum = 0.0;
			for (int i = 0; i < arr.length(); i++) {
				sum +=  arr.getIndex(i).doubleValue();
			}

		return (sum / arr.length());
	}

}
