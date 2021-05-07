package geArea;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyUtils6 {
	public List<Shape> maxAreas(List<Shape> shapes) {
		List<Rectangle> rectangles = new ArrayList<>();
		List<Circle> circles = new ArrayList<>();
		for (Shape shape : shapes){
            if (shape instanceof Rectangle){
                rectangles.add((Rectangle) shape);
            }
            if (shape instanceof Circle){
                circles.add((Circle) shape);
            }
        }
		int rec = rectangles.stream().mapToInt(r ->r.getArea()).max().orElse(0);
		rectangles = rectangles.stream().filter(r -> r.getArea() == rec).collect(Collectors.toList());
		
		int cir = circles.stream().mapToInt(c ->c.getArea()).max().orElse(0);
		circles = circles.stream().filter(c -> c.getArea() == cir).collect(Collectors.toList());
		shapes.add((Shape) circles);
		shapes.add((Shape) rectangles);
		System.out.println(shapes);
		return shapes;
    }
}
