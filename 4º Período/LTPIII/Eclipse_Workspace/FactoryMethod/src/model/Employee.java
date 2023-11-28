package model;

public abstract class Employee {
	private String position;

	public Employee(String position) {
		this.position = position;
	}

	public String getPosition() {
		return this.position;
	}

	public abstract double calculateSalary();
}
