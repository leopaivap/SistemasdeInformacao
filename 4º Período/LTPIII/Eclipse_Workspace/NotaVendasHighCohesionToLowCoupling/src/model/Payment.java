package model;

public abstract class Payment {
	protected abstract String description();

	protected abstract Double value(double saleValue);

}
