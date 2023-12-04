package view;

import model.Country;
import model.CountryEmployeeFactory;
import model.Employee;
import model.EmployeeFactory;
import model.EmployeeType;
import model.us.USEmployeeFactory;

public class Main {

	public static void main(String[] args) {

		EmployeeFactory factory = CountryEmployeeFactory.createObject(Country.BR);

		Employee employee = factory.createEmployee(EmployeeType.MANAGER);

		System.out.println(employee.getPosition() + " " + employee.calculateSalary());
	}
}
