package model;

public class Product {
	private String name;
	private double cost;
	private int stockQuantity;

	public Product(String name, double cost, int stockQuantity) throws Exception {
		setName(name);
		setCost(cost);
		setStock(stockQuantity);
	}

	protected static boolean stockValidate(Product prod, int amount) throws Exception {
		if (prod.stockQuantity >= amount)
			return true;
		else if (prod.stockQuantity <= 0)
			throw new Exception("Item fora de estoque!");
		else
			throw new Exception("Quantidade de " + prod.getName() + " Indísponível!");
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

	private void setStock(int stockQuantity) throws Exception {
		if (stockQuantity < 0)
			throw new Exception("Valor de Estoque Inválido!");

		this.stockQuantity = stockQuantity;
	}

}
