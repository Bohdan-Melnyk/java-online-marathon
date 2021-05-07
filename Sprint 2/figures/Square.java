package figures;

public class Square {
	private double width;

	public Square(double width) {
		this.width = width;
	}
	public Square() {}
	
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getPerimeter() {
		return width * 4;
	}
}
