package model;

public class Manager extends Employee {

	private int subordinates;
	private double percentPerSubordinado;
	private int doneProjects;
	private double bonusPerProject;

	public Manager(String name, double salary, int subs, double percent, int doneProjs, double bonusProj) {
		super(name, "Gerente", salary);

		this.subordinates = subs;
		this.percentPerSubordinado = percent / 100;
		this.doneProjects = doneProjs;
		this.bonusPerProject = bonusProj;
	}

	@Override
	public double salary() {
		// Implementação da forma de cálculo do sálario desse tipo de funcionário
		double valuePerSub = getSalary() * percentPerSubordinado;
		double extraBonus = valuePerSub * subordinates;
		double projetsBonus = doneProjects * bonusPerProject;

		return baseSalary() + extraBonus + projetsBonus;
	}
}
