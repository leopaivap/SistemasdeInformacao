package model.br;

import model.Employee;
import model.EmployeeFactory;
import model.EmployeeType;

public class BREmployeeFactory implements EmployeeFactory {

	@Override
	public Employee createEmployee(EmployeeType type) {

		if (type == EmployeeType.MANAGER)
			return new ManagerBR();
		
		else if (type == EmployeeType.PROGRAMMER)
			return new ProgrammerBR();

		return null;
	}

}
