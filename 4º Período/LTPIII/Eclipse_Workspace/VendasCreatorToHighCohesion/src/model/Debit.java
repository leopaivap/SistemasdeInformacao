package model;

public class Debit implements Payment {

	private double discount;
	
	public Debit(double disconut) {
		this.discount = disconut/100;
	}
	
	@Override
	public String description() {
		return "Cartão de Débito";
	}

	@Override
	public Double value(Double saleValue) {
		double value = saleValue - (saleValue * this.discount); 
		return value;
	}
	
}
