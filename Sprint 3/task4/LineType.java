package task4;

public enum LineType {
	SOLID("solid"), 
	DOTTED("dotted"),
	DASHED("dahed"), 
	DOUBLE("double");
	
	private String in;
	private LineType(String in) {
		this.in = in;
	}
	public String getIn() {
		return in;
	}
}
