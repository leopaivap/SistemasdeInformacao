package model;

import java.util.ArrayList;
import java.util.List;

public class Product {
	private String name;
	private double costPrice, profit;
	private boolean national;
	private List<Tax> taxes;

	public Product(String name, double costPrice, double profit, boolean national) throws Exception {
		setName(name);
		setCostPrice(costPrice);
		setProfit(profit);
		this.national = national;
		this.taxes = new ArrayList<>();
	}

	public boolean addTax(Tax tax) throws Exception {

		if (tax == null)
			throw new Exception("Imposto não pode ser nulo.");

		if (taxes.contains(tax))
			return false;

		else if (tax.getAbbr().equals("ICMS")) {
			boolean containsIpi = false;
			for (Tax taxSearch : this.taxes) {
				if (taxSearch.getAbbr().equals("IPI")) {
					containsIpi = true;
					break;
				}
			}

			taxes.add(tax);
			if (!containsIpi)
				tax.updateAliquot(7);

		} else if (tax.getAbbr().equals("IPI")) {
			for (Tax taxSearch : this.taxes) {
				if (taxSearch.getAbbr().equals("ICMS")) {
					taxSearch.updateAliquot(5);
					break;
				}
			}
			taxes.add(tax);

			if (!this.isNational())
				tax.updateAliquot(10);

		} else
			taxes.add(tax);

		return true;
	}

	public double calculateSalePrice() {
		// Calcular os impostos
		double taxesSum = 0;

		for (Tax tax : taxes) {
			if (tax.getAbbr().equals("ISS"))
				taxesSum += tax.calculateIss(this);
			else
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

	public boolean isNational() {
		return national;
	}

	public double getProfit() {
		return profit;
	}

}
