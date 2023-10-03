package view;

import model.Sale;

public class Main {

	public static void main(String[] args) throws Exception {

		Sale venda = new Sale();
		venda.addCart("arroz", 2);
		venda.addCart("sal", 10);
		venda.addCart("feijao", 1);
		venda.addCart("pao", 2);

		venda.printSale();

	}
}
