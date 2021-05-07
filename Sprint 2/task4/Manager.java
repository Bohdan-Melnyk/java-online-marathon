package task4;

import java.math.BigDecimal;

public class Manager extends Employee {
	private double coefficient;

	@Override
	public BigDecimal getPayment() {
		return super.getPayment().multiply(new BigDecimal(coefficient));
	}
	
}
