package geArea;

public class Circle extends Shape {
	double radius;

	@Override
	public int getArea() {
		return (int) (Math.PI * radius * radius);
	}

	public Circle(String name, double radius) {
		super(name);
		this.radius = radius;
	}
	
}
