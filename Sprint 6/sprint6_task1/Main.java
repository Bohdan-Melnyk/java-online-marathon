package sprint6_task1;

import sprint6_task2.*;

public class Main {

	public static void main(String[] args) {
		double[] arr = new double[] {1, 33.32, 2.3, 2};
		App app = new App();
		System.out.println(app.getChanged(arr, app.cons));
	}

}
