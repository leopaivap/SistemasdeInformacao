package model;

public class TecLeader extends Employee {

	private int subordinates;
	private double percentPerSubordinate;

	public TecLeader(String name, double salary, int subs, double percent) {
		super(name, "Líder Técnico", salary);

		this.subordinates = subs;
		this.percentPerSubordinate = percent / 100;
	}

	@Override
	public double salary() {
		// Implementação da forma de cálculo do sálario desse tipo de funcionário
		double valuePerSub = getSalary() * percentPerSubordinate;
		double extraBonus = valuePerSub * subordinates;

		return baseSalary() + extraBonus;
	}
}
