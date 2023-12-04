package model;

import model.br.BREmployeeFactory;
import model.us.USEmployeeFactory;

public class CountryEmployeeFactory {

	public static EmployeeFactory createObject(Country country) {
		if (country == null)
			return null;

		if (country == Country.BR)
			return new BREmployeeFactory();

		return new USEmployeeFactory();
	}
}
