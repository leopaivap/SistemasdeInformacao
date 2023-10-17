package model;

public class Credit extends Payment {
	private double fees;

	public Credit(double fees) {
		this.setFees(fees);
	}

	public void setFees(double fees) {
		if (fees >= 0)
			this.fees = fees / 100;
	}

	@Override
	protected String description() {
		return "Cartão de Crédito";
	}

	@Override
	protected Double value(double saleValue) {
		double value = saleValue + (saleValue * this.fees);
		return value;
	}

}
