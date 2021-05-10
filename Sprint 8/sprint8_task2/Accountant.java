package sprint8_task2;

import java.util.function.BinaryOperator;

import sprint8_task1.*;

public class Accountant {

	static BinaryOperator<Integer> BiOperator = (a, b) -> a + b;

	public static int sum(int x, int y) throws InterruptedException {
		ParallelCalculator calc = new ParallelCalculator(Integer::sum, x, y);
		Thread thread = new Thread(calc);
		thread.start();
		thread.join();
		return 0;
	}
}
