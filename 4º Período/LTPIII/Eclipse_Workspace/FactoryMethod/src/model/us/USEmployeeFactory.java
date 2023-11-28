package model.us;

import model.Employee;
import model.EmployeeFactory;
import model.EmployeeType;

public class USEmployeeFactory implements EmployeeFactory {

	@Override
	public Employee createEmployee(EmployeeType type) {

		if (type == EmployeeType.MANAGER)
			return new ManagerUS();
		
		else if (type == EmployeeType.PROGRAMMER)
			return new ProgrammerUS();

		return null;
	}

}
