package model;

public class Triangle implements Shape {
	private double width, height;

	public Triangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public String name() {
		return "Triângulo";
	}

	@Override
	public double area() {
		return (this.width * this.height) / 2;
	}
}
