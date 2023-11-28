package model.us;

import model.Employee;

public class ProgrammerUS extends Employee {
	
	public ProgrammerUS() {
		super("Programador Americano");
	}

	@Override
	public double calculateSalary() {
		return 7500.20;
	}

}
