package model.us;

import model.Employee;

public class ManagerUS extends Employee {
	
	public ManagerUS() {
		super("Gerente Americano");
	}

	@Override
	public double calculateSalary() {
		return 10000.20;
	}

}
