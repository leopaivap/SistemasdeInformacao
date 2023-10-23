package model;

public class Debit extends Payment {
	private double discount;

	public Debit(double discount) {
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
		return "Cartão Débito";
	}

	@Override
	protected Double value(double saleValue) {
		double value = saleValue - (saleValue * this.discount);
		return value;
	}
}
