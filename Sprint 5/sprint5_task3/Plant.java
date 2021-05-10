package sprint5_task3;

public class Plant {
	private String name;
	Color color;
	Type type;

	public Plant(String type, String color, String name)
			throws ColorException, TypeException, IllegalArgumentException {
		try {
			this.type = Type.valueOf(type.toUpperCase());
		} catch (IllegalArgumentException e) {
			if (!type.equals(String.valueOf(Type.RARE).toLowerCase())
					|| !type.equals(String.valueOf(Type.ORDINARY).toLowerCase())) {
				throw new TypeException("Invalid value " + type + " for field type");
			}
		}
		try {
			this.color = Color.valueOf(color.toUpperCase());
		} catch (IllegalArgumentException e) {
			if (!color.equals(Color.WHITE.toString().toLowerCase()) || 
					!color.equals(Color.RED.toString().toLowerCase())
					|| !color.equals(Color.BLUE.toString().toLowerCase())) {
				throw new ColorException("Invalid value " + color + " for field color");
			}
		}
		
		this.name = name;
	}

	static Plant tryCreatePlant(String type, String color, String name) throws ColorException, TypeException {
		try {
			return new Plant(type, color, name);
		} catch (ColorException e) {
			try {
				return new Plant(type, "Red", name);
			} catch (TypeException ex) {
				return new Plant("Ordinary", "Red", name);
			}
		} catch (TypeException e) {
			try {
				return new Plant("Ordinary", color, name);
			} catch (ColorException ex) {
				return new Plant("Rare", "red", name);
			}
		}
	}

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
