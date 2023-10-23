package view;

import model.SaleManager;

public class Main {

	public static void main(String[] args) throws Exception {

		SaleManager saleManager = new SaleManager();
		saleManager.openSale();
		saleManager.addItem("arroz", 2);
		saleManager.addItem("sal", 10);
		saleManager.addItem("feijao", 1);
		saleManager.addItem("pao", 2);

		// cc - cartao credito
		// cd - cartao debito
		// c - dinheiro / pix
		saleManager.paymentMethod("cc");

		saleManager.printSale();

	}
}
