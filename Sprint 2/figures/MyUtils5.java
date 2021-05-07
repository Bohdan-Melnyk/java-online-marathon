package figures;

import java.util.ArrayList;
import java.util.List;

public class MyUtils5 {
	public double sumPerimeter(List<?> firures) {
		List<Square> sq = new ArrayList<>();
		List<Rectangle> rec = new ArrayList<>();
//		for (int i = 0; i < firures.size(); i++) {
//			if (firures.get(i) instanceof Square) {
//				sq.add((Square) firures.get(i));
//			}
//			if (firures.get(i) instanceof Rectangle) {
//				rec.add((Rectangle) firures.get(i));
//			}
//		}
		for (Object f : firures) {
			if (f instanceof Square) {
				sq.add((Square) f);
			}
			if (f instanceof Rectangle) {
				rec.add((Rectangle) f);
			}
		}
		return getSumSquare(sq) + getSumRectangle(rec);
	}
	public double getSumSquare(List<Square> square) {
		double sum = 0;
		for (Square s : square) {
			sum += s.getPerimeter();
		}
		return sum;
	}
	public double getSumRectangle(List<Rectangle> rectangle) {
		double sum = 0;
		for (Rectangle r : rectangle) {
			sum += r.getPerimeter();
		}
		return sum;
	}
}
