package task3;

public class Task3 {
	
	public static void execute(int a, int b, Strategy strategy) {
		double res = strategy.doOperation(a, b);
		System.out.println(res);
	}
	
	public static void addAtoB(int a, int b) {
		execute(a, b, new Strategy() {
			
			@Override
			public double doOperation(int a, int b) {
				return a + b;
			}
		});
	}
	
	public static void subtractBfromA(int a, int b) {
		execute(a, b, new Strategy() {
			
			@Override
			public double doOperation(int a, int b) {
				return a - b;
			}
		});
	}
	
	public static void multiplyAbyB(int a, int b) {
		execute(a, b, new Strategy() {
			
			@Override
			public double doOperation(int a, int b) {
				return a * b;
			}
		});
	}
	
	public static void divideAbyB(int a, int b) {
		execute(a, b, new Strategy() {
			
			@Override
			public double doOperation(int a, int b) {
				return a / b;
			}
		});
	}
}


interface Strategy{
	double doOperation(int a, int b);
}