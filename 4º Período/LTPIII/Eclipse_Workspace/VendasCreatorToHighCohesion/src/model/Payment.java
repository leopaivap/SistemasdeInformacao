package model;

public interface Payment {
	String description();
	Double value(Double saleValue);
}
