package sprint5_task2;

public enum Type {
	RARE("Rare"),
	ORDINARY("Ordinary");
	private String type;

	private Type(String type) {
		this.type = type;
	}
	public String getTypeName() {
		return type;
	}
}
