package figures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Square s1 = new Square(3);
		Rectangle r1 = new Rectangle(3, 2);
		Rectangle r2 = new Rectangle(1, 2);
		Square s2 = new Square(2);
		Square s3 = new Square(2);
		List<?> figures = new ArrayList<>();
		List<Square> sq = new ArrayList<>();
		List<Rectangle> rec = new ArrayList<>();
		sq.add(s1);
		sq.add(s2);
		sq.add(s3);
		rec.add(r1);
		rec.add(r2);
		MyUtils5 my = new MyUtils5();
		my.sumPerimeter(figures);
		
//		System.out.println(my.sumPerimeter());
		System.out.println(my.getSumRectangle(rec));
	}

}
