package model;

public class Square implements Shape {
	private double side;

	public Square(double side) {
		this.side = side;
	}

	@Override
	public String name() {
		return "Quadrado";
	}

	@Override
	public double area() {
		return (this.side * this.side);
	}
}
