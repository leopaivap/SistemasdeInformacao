package model.br;

import model.Employee;

public class ProgrammerBR extends Employee {

	public ProgrammerBR() {
		super("Programador Brasileiro");
	}

	@Override
	public double calculateSalary() {
		return 10000.20;
	}

}
