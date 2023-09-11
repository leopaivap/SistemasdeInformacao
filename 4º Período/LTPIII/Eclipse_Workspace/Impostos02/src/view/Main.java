package view;

import model.Product;
import model.Tax;

public class Main {

	public static void printProduct(Product prod) {
		System.out.println("Nome: " + prod.getName());
		System.out.printf("Valor: R$%.2f\n", prod.calculateSalePrice());
		System.out.println("------------------");
	}

	public static void main(String[] args) throws Exception {
		// produtos
		Product arroz = new Product("Arroz Pileco", 7, 20, true);
		Product feijao = new Product("Feijão", 7, 25, true);
		Product carne = new Product("Carne", 7, 35, true);
		Product cerveja = new Product("Cerveja", 7, 30, true);
		Product gas = new Product("Gás", 7, 15, true);
		Product gasolina = new Product("Gasolina", 7, 15, true);

		// impostos
		Tax ipi = new Tax("IPI", "Imposto Prod. Industrializado", 8);
		Tax iss = new Tax("ISS", "Imposto Circ. Mercadorias", 5);
		Tax icms = new Tax("ICMS", "I. C. Mercadorias", 5);

		// adicionando impostos aos produtos
		arroz.addTax(icms);
		arroz.addTax(iss);

		feijao.addTax(icms);
		feijao.addTax(iss);

		carne.addTax(ipi);
		carne.addTax(icms);

		cerveja.addTax(icms);
		cerveja.addTax(iss);
		cerveja.addTax(ipi);

		gas.addTax(ipi);
		gas.addTax(icms);

		gasolina.addTax(icms);

		// mostrando produtos
		printProduct(arroz);
		printProduct(feijao);
		printProduct(carne);
		printProduct(cerveja);
		printProduct(gas);
		printProduct(gasolina);

	}

}