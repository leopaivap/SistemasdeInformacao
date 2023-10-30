package model;

public class Cash implements Paymmnet{

	private double discout;
	
	public Cash(double discout) {
		this.discout = discout/100;
	}
	
	@Override
	public String description() {
		return "Dinheiro/Pix";
	}

	@Override
	public Double value(Double saleValue) {	
		double value = saleValue - (this.discout * saleValue);

		return value;
	}
}
