package sprint5_task1;

public class Task1 {

	public static void main(String[] args) {
		

	}
	
	 public static  int squareRectangle (int a, int b) throws IllegalArgumentException {
		 return 2 * (a + b);
	 }
	 
	 public static int trySquareRectangle(int a, int b) {
		 int sq = 0;
		 if ((a <= 0 || b <= 0) || (a <= 0 && b <= 0)) {
			 sq = -1;
		 } else {
			 sq = 2 * (a + b);
		 }
	     return sq;
	 } 
	 
	 public static  int squareRectangle2 (int a, int b) {
		 if ((a <=0) || (b <= 0)) {
			 throw new IllegalArgumentException("both arguments should be more than zero");
		 }
		 return a * b; 
	 }
	 
	 public static int trySquareRectangle2(int a, int b) {
		 int sq = 0;
		 if ((a <=0) || (b <= 0)) {
			 sq = -1;
		 } else {
			 sq = squareRectangle(a, b);
		 }
	     return sq;
	 } 
}
