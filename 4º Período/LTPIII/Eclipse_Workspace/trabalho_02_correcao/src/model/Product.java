package model;

import java.util.ArrayList;
import java.util.List;

public class Product {
	private String name;
	private double costPrice, profit;
	private boolean foreign, industrial;
	private List<Tax> taxes;

	public Product(String name, double costPrice, double profit) throws Exception {
		this.foreign = false;
		this.industrial = false;
		setName(name);
		setCostPrice(costPrice);
		setProfit(profit);
		this.taxes = new ArrayList<>();
	}

	public void setIsForeign(boolean foreign) {
		this.foreign = foreign;
	}

	public boolean isForeign() {
		return this.foreign;
	}

	public void setIndustrial(boolean industrial) {
		this.industrial = industrial;
	}

	public boolean isIndustrial() {
		return this.industrial;
	}

	public boolean addTax(Tax tax) throws Exception {

		if (tax == null)
			throw new Exception("Imposto não pode ser nulo.");

		if (taxes.contains(tax))
			return false;
		else {
			tax.defineAliquot(this);
			taxes.add(tax);
		}

		return true;
	}

	public double calculateSalePrice() {
		// Calcular os impostos
		double taxesSum = 0;

		for (Tax tax : taxes) {
			taxesSum += tax.calculate(this);
		}

		double finalCost = this.costPrice + taxesSum;
		double finalPrice = finalCost + (finalCost * profit);

		return finalPrice;

	}

	private void setProfit(double profit) throws Exception {

		if (profit <= 0)
			throw new Exception("Margem está Inválida!");

		this.profit = profit / 100;
	}

	public double getProfit() {
		return profit;
	}

	private void setCostPrice(double costPrice) throws Exception {

		if (costPrice <= 0)
			throw new Exception("Preço de custo está inválido!");

		this.costPrice = costPrice;
	}

	private void setName(String name) throws Exception {

		if (name == null || name.equals(""))
			throw new Exception("Nome Inválido!");

		this.name = name;
	}

	public String getName() {
		return name;
	}

	public double getCostPrice() {
		return costPrice;
	}
}