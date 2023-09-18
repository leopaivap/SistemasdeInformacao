package view;

import model.ICMS;
import model.IPI;
import model.Product;
import model.Tax;

public class Main {

	public static void main(String[] args) throws Exception {
		// Arroz
		Product arroz = new Product("Arroz Pileco", 100, 30);
		arroz.setIndustrial(true);

		Tax ipi = new IPI();
		Tax icms = new ICMS();
		arroz.addTax(ipi);
		arroz.addTax(icms);

		// Extrato de Tomate
		Product extratoTomate = new Product("Extrato Heinz", 100, 20);
		extratoTomate.setIndustrial(true);
		extratoTomate.setIsForeign(true);

		Tax ipiTomate = new IPI();
		extratoTomate.addTax(ipiTomate);

		// Outro Produto

		printProduct(arroz);
		printProduct(extratoTomate);

	}

	public static void printProduct(Product p) {
		System.out.println(p.getName() + " -> R$" + p.calculateSalePrice());
	}

}
