package model;

public class Cash extends Payment {
	private double discount;

	public Cash(double discount) {
		this.setDiscount(discount);
	}

	public void setDiscount(double discount) {
		if (discount >= 0)
			this.discount = discount / 100;
	}

	public double getDiscount() {
		return discount;
	}

	@Override
	protected String description() {
		return "Dinheiro/Pix";
	}

	@Override
	protected Double value(double saleValue) {
		double value = saleValue - (this.discount * saleValue);
		return value;
	}

}
