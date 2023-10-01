package view;

import model.Product;
import model.Sale;

public class Main {

	public static void main(String[] args) throws Exception {
		Product arroz = new Product("Arroz", 20, 30);
		Product feijao = new Product("Feijão", 30, 15);
		Product macarrao = new Product("Macarrão", 12, 45);
		Product pao = new Product("Pão", 2.5, 82);

		Sale venda = new Sale();
		venda.addCart(pao, 2);
		venda.addCart(macarrao, 10);
		venda.addCart(arroz, 1);
		venda.addCart(feijao, 2);

		venda.printSale();

	}
}
