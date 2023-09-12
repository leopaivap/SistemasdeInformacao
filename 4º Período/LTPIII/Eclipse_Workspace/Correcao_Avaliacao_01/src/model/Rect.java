package model;

public class Rect implements Shape {
	private double width, height;

	public Rect(double width, double height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public String name() {
		return "Retângulo";
	}

	@Override
	public double area() {
		return (this.width * this.height);
	}
}
