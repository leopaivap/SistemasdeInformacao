package model;

public class StockItem {
	private int stockAmount;
	private Product product;

	StockItem(Product product, int stockAmount) {
		this.product = product;
		this.stockAmount = stockAmount;
	}

	public Product getProduct() {
		return this.product;
	}

	public int getAmount() {
		return this.stockAmount;
	}

	public void removeFromStock(int amount) {
		this.stockAmount = amount;
	}
}
