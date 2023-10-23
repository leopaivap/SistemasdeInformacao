package model;

public class Product {
	private String name;
	private double cost;

	public Product(String name, double cost) throws Exception {
		setName(name);
		setCost(cost);
		// DataProducts.addList(this);
	}

	public String getName() {
		return name;
	}

	public double getCost() {
		return cost;
	}

	private void setName(String name) throws Exception {

		if (name == null || name.equals(""))
			throw new Exception("Nome Inválido!");

		this.name = name;
	}

	private void setCost(double cost) throws Exception {

		if (cost <= 0)
			throw new Exception("Preço de custo está inválido!");

		this.cost = cost;
	}

}
