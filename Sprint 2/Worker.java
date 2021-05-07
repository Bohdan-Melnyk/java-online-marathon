
public class Worker extends Person {
	private String workPosition;
	private int experianceYears;
	
	public String getWorkPosition() {
		return workPosition;
	}
	public int getExperianceYears() {
		return experianceYears;
	}
	public Worker(String name, String workPosition, int experianceYears) {
		super(name);
		this.workPosition = workPosition;
		this.experianceYears = experianceYears;
	}
	@Override
	public String toString() {
		return "Worker [workPosition=" + workPosition + ", experianceYears=" + experianceYears + "]";
	}
	
}
