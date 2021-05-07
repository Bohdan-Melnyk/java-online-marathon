package geArea;

public class Rectangle extends Shape {
	double height;
	double width;
	@Override
	public int getArea() {
		return (int) (Math.pow(height, 2) + Math.pow(width, 2));
	}
	public Rectangle(String name, double height, double width) {
		super(name);
		this.height = height;
		this.width = width;
	}
	
}
