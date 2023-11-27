package model;

public class EmployeeFactory {

	public enum EmployeeType {
		ANALYST, ARCHITECT, MANAGER, TECLEADER
	}

	public static Employee createEmployee(EmployeeType id, String name, double salary, double percent, int subs, int projects ) {

		switch (id) {
		case ANALYST: {
			return new Analyst(name, salary);
		}

		case ARCHITECT: {
			return new Architect(name, salary, percent, 0);
		}

		case MANAGER: {
			return new Manager(name, salary, subs, percent, 0, 0);
		}

		case TECLEADER: {
			return new TecLeader(name, salary, subs, percent);
		}

		default:
			return null;
		}

	}
}
