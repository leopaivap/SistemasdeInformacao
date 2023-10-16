package model;

public class Credit extends Payment {

	public Credit(double fees) {
		this.setFees(fees);
		this.setDescription("Cartão de Crédito");
	}

	@Override
	protected double setFinalSalePrice(double totalSalePrice) {
		totalSalePrice = (totalSalePrice + (totalSalePrice * this.getFees()));
		return totalSalePrice;
	}
}
