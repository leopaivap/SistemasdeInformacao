package model;

public class SaleManager {
	private Sale sale;
	private Stock stock;

	public SaleManager() {
		stock = new Stock();
		sale = null;
	}

	public void openSale() throws Exception {
		sale = new Sale();
	}

	public void closeSale() {
		sale = null;
	}

	public boolean isOpen() {
		return sale != null;
	}

	public boolean addItem(String productId, int amount) throws Exception {
		if (!isOpen())
			return false;

		if (stock.hasAmount(productId, amount)) {
			sale.addCart(productId, amount);
			return true;
		}

		return false;
	}

	public void paymentMethod(String method) {
		if (!isOpen())
			sale.addPayment(method);
	}

	public void printSale() {
		if (!isOpen())
			sale.printSale();
	}
}
