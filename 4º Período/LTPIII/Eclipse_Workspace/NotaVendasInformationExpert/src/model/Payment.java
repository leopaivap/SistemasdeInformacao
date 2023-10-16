package model;

public abstract class Payment {
	private double fees;
	private String description;

	public double getFees() {
		return fees;
	}

	protected void setFees(double fees) {
		if (fees >= 0)
			this.fees = fees / 100;
	}

	public String getDescription() {
		return description;
	}

	protected void setDescription(String description) {
		this.description = description;
	}

	protected abstract double setFinalSalePrice(double totalPriceSale);

}
