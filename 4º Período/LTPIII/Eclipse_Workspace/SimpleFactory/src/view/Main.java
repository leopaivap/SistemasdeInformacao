package view;

import model.Employee;
import model.EmployeeFactory;
import model.EmployeeFactory.EmployeeType;

public class Main {
	
	public static void main(String[] args) {
		Employee e = EmployeeFactory.createEmployee(EmployeeType.MANAGER, "Emerson", 2000, 5, 8, 0);
		
	}
}
