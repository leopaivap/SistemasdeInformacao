package model;

public class Debit extends Payment {
	private double discount;

	public Debit(double fees, double discount) {
		this.setFees(fees);
		this.setDescription("Cartão de Débito");
		this.setDiscount(discount);
	}
	
	public void setDiscount(double discount) {
		if(discount >= 0)
			this.discount = discount/100;
	}

	public double getDiscount() {
		return discount;
	}

	@Override
	protected double setFinalSalePrice(double totalSalePrice) {
		totalSalePrice = ((totalSalePrice - (totalSalePrice * this.discount)) + (totalSalePrice * this.getFees()));
		return totalSalePrice;
	}
}
