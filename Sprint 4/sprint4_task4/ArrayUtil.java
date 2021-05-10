package sprint4_task4;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayUtil {
	public static <T> T setAndReturn(T[] arr, T symb, int x) {
		for (int i = 0; i < arr.length; i++) {
			if (i == x) {
				arr[i] = symb;
			}
		}
		return symb;
		
	}
}
