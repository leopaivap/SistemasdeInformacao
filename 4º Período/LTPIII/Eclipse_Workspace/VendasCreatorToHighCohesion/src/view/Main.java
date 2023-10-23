package view;

import model.Sale;

public class Main {

	public static void main(String[] args) {
		Sale sale = new Sale();
		sale.addItem("arroz", 3);
		sale.addItem("feijao", 2);
		sale.addItem("sal", 1);
		// cc - Crédito
		// cd - Débito
		// c - Dinheiro/Pix
		sale.addPaymment("cd");
		
		System.out.println(String.format("Venda - #1234 - %s", 
				sale.getDate().toLocaleString()));
		
		for (String si : sale.getSaleItems()) {
			System.out.println(si);
		}
		
		System.out.println(String.format("Total: R$:%.2f", sale.getTotal()));
		
		System.out.println("Forma de pagamento: " + sale.getPaymment());
		System.out.println("Valor a ser pago: " + sale.paymmentValue());
	}
}
