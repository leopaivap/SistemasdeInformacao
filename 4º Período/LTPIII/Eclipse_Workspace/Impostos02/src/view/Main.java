package view;

import model.Product;
import model.Tax;

public class Main {

	public static void main(String[] args) throws Exception {
		Product arroz = new Product("Arroz Pileco", 7, 20, true);

		Tax ipi = new Tax("IPI", "Imposto Prod. Industrializado", 8);
		Tax iss = new Tax("ISS", "Imposto Circ. Mercadorias", 5);
		Tax icms = new Tax("ICMS", "I. C. Mercadorias", 5);

		//arroz.addTax(ipi);
		arroz.addTax(icms);
		arroz.addTax(iss);


		System.out.println(arroz.getName() + " R$:" + arroz.calculateSalePrice());

	}

}