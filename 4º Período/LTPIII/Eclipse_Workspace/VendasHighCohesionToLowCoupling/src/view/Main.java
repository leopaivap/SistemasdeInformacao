package view;

import model.SaleManager;

public class Main {

	public static void main(String[] args) {
		SaleManager manager = new SaleManager();
		manager.openSale();
		manager.addItem("arroz", 3);
		manager.addItem("feijao", 2);
		manager.addItem("sal", 1);
		// cc - Crédito
		// cd - Débito
		// c - Dinheiro/Pix
		manager.addPaymment("cd");
		
		System.out.println(String.format("Venda - #1234 - %s", 
				manager.getDate().toLocaleString()));
		
		for (String si : manager.getSaleItems()) {
			System.out.println(si);
		}
		
		System.out.println(String.format("Total: R$:%.2f", manager.getTotal()));
		
		System.out.println("Forma de pagamento: " + manager.getPaymment());
		System.out.println("Valor a ser pago: " + manager.paymmentValue());
	}
}
