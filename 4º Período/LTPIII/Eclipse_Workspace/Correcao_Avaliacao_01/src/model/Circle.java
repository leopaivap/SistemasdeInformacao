package model;

public class Circle implements Shape {
	private double radius;
	private static final double PI = 3.1415;

	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public String name() {
		return "Círculo";
	}

	@Override
	public double area() {
		return (this.radius * this.radius) * PI;
	}
}
