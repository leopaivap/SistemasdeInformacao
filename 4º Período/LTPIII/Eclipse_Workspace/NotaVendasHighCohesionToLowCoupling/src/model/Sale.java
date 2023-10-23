package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Sale {

	private List<SaleItem> cart = new ArrayList<>();
	private double totalPriceCart;
	private Date date;
	private Payment paymentMethod;

	public Sale() throws Exception {
		this.date = Calendar.getInstance().getTime();
		this.cart = new ArrayList<>();
	}

	protected void addCart(String productId, int amount) throws Exception {
		SaleItem item = new SaleItem(productId, amount);
		cart.add(item);
		totalPriceCart += item.getTotalPriceItem();
	}

	public Date getDate() {
		return date;
	}

	protected void printSale() {
		if (cart != null) {
			System.out.println(String.format("Venda - #1234 - %s\n", this.getDate().toLocaleString()));
			System.out.println("\tProduto\t\tQtd\tUnd\tTotal\n");
			for (SaleItem saleItem : cart) {
				String productName = saleItem.getSaleProduct().getName();
				if (productName.length() > 6)
					productName = saleItem.getSaleProduct().getName().substring(0, 6);

				System.out.println("\t" + productName + "\t\t" + saleItem.getAmount() + "\t"
						+ saleItem.getSaleProduct().getCost() + "\t" + saleItem.getTotalPriceItem());
				System.out.println("--------------------------------------------------------");
			}
			System.out.println("Total Carrinho: R$" + this.totalPriceCart);
			System.out.println("Forma de Pagamento: " + this.getPayment());
			System.out.println("Valor a ser pago: R$" + this.paymentValue());
		}
	}

	public double getTotalPriceCart() {
		return totalPriceCart;
	}

	protected void addPayment(String method) {
		this.paymentMethod = DataProducts.getPayment(method);
	}

	public String getPayment() {
		return this.paymentMethod.description();
	}

	public double paymentValue() {
		return this.paymentMethod.value(getTotalPriceCart());
	}

}
