package sprint5_task2;

import sprint5_task3.ColorException;

public class Plant {
	private String name;
	Color color;
	Type type;

	public Plant(String name, String color, String type)
			throws ColorException, TypeException, IllegalArgumentException {
		this.name = name;

		try {
			this.color = Color.valueOf(color.toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new ColorException("Invalid value " + color + " for field color");
		}
		try {
			this.type = Type.valueOf(type.toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new TypeException("Invalid value " + type + " for field type");
		}
	}
	public Plant() {}

	public String getName() {
		return name;
	}

	public Color getColor() {
		return color;
	}

	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return "{type: " + type + ", color: " + color + ", name: " + name + "}";
	}

}
