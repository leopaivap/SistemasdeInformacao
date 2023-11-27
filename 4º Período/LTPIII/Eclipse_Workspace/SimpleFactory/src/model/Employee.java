package model;

public abstract class Employee {
	private String name;
	private String role; // Cargo
	private double salary;
	private double perExtraHourValue; // Valor por hora
	private double extraHours; // Quantidade horas extras

	public Employee(String name, String role, double salary) {
		this.name = name;
		this.role = role;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	public double getPerExtraHourValue() {
		return perExtraHourValue;
	}

	public double getExtraHours() {
		return extraHours;
	}

	protected double getSalary() {
		return this.salary;
	}

	public void setPerExtraHourValue(double perExtraHourValue) {
		this.perExtraHourValue = perExtraHourValue;
	}

	public void setExtraHours(double extraHours) {
		this.extraHours = extraHours;
	}

	protected double baseSalary() {
		double extraEarnings = getExtraHours() * getPerExtraHourValue();

		return salary + extraEarnings;
	}

	public abstract double salary();
}
