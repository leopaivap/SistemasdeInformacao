package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Sale {

	private List<SaleItem> cart = new ArrayList<>();
	private double totalPriceCart;
	private Date date;
	//private Payment paymentMethod;

	public Sale() throws Exception {
		this.date = Calendar.getInstance().getTime();
		this.cart = new ArrayList<>();
	}

	public void addCart(String productId, int amount) throws Exception {
		SaleItem item = new SaleItem(productId, amount);
		cart.add(item);
		totalPriceCart += item.getTotalPriceItem();
	}

	public Date getDate() {
		return date;
	}

	public void printSale() {
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
		}
	}

	protected double getTotalPriceCart() {
		return totalPriceCart;
	}

	protected void setTotalPriceCart(double totalPriceCart) {
		this.totalPriceCart = totalPriceCart;
	}

}
