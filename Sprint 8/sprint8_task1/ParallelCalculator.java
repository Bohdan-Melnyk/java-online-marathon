package sprint8_task1;

import java.util.function.BinaryOperator;

public class ParallelCalculator implements Runnable {

	int result;

	public ParallelCalculator(BinaryOperator<Integer> BiOperator, int operand1, int operand2) {
		result = BiOperator.apply(operand1, operand2);
	}

	@Override
	public void run() {

	}

}

class Accountant {

	public static int sum(int x, int y) {
		ParallelCalculator calc = new ParallelCalculator(Integer::sum, x, y);
		try {
			Thread thread = new Thread(calc);
			thread.start();
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return calc.result;
	}
}