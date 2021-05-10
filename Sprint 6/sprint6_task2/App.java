package sprint6_task2;

import java.util.Arrays;
import java.util.function.Consumer;

public class App {

	public static Consumer<double[]> cons = array -> {
		for (int i = 0; i < array.length; i++) {
			if (array[i] > 2) {
				array[i] *= 0.8;
			} else {
				array[i] *= 0.9;
			}
		}
	};

	public static double[] getChanged(double[] initialArray, Consumer<double[]> cons) {
		double[] newArr = initialArray.clone();
		cons.accept(newArr);
		return newArr;
	}
}
