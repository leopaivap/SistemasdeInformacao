package model;

public class Architect extends Employee {

	private int projects;
	private double percetualPerProject;

	public Architect(String name, double salary, double percetual, int projects) {
		super(name, "Arquiteto", salary);

		this.projects = projects;
		this.percetualPerProject = percetual / 100;
	}

	@Override
	public double salary() {
		// Implementação da forma de cálculo do sálario desse tipo de funcionário
		double bonusPerProjetc = getSalary() * percetualPerProject;
		double extraBonus = bonusPerProjetc * this.projects;

		return baseSalary() + extraBonus;
	}
}
