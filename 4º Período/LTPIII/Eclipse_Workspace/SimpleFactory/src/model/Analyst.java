package model;

public class Analyst extends Employee {

	public Analyst(String name, double salary) {
		super(name, "Analista", salary);
	}

	@Override
	public double salary() {
		// Implementação da forma de cálculo do sálario desse tipo de funcionário
		return baseSalary();
	}
}
