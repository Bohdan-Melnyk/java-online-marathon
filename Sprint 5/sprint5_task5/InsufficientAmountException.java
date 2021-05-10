package sprint5_task5;

public class InsufficientAmountException extends Exception {
	private int errCode;
	private double amount;
	
	public String getMessage() {
		return "Sorry, but you are short $ " + amount;
	}
	public InsufficientAmountException(double amount) {
		this.amount = amount;
	}
	
	public String getAmount() {
		return String.valueOf(amount);
	}
}
