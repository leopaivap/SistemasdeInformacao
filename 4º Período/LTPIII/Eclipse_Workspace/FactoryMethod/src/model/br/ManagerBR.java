package model.br;

import model.Employee;

public class ManagerBR extends Employee {

	public ManagerBR() {
		super("Gerente Brasileiro");
	}

	@Override
	public double calculateSalary() {
		return 15000.20;
	}

}
