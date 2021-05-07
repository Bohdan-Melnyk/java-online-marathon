package geArea;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		MyUtils6 my = new MyUtils6();
		List<Shape> shapes = new ArrayList<>();
		shapes.add(new Circle("Cirle1", 3));
		shapes.add(new Rectangle("Rectangle1", 2, 3));
		shapes.add(new Circle("Cirle1", 3));
		shapes.add(new Rectangle("Rec2", 3, 4));
		my.maxAreas(shapes);
	}

}
