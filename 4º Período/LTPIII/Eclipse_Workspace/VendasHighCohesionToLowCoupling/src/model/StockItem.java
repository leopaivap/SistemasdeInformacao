package model;

public class StockItem {
	private Product product;
	private int amount;
	
	public StockItem(Product p, int a) {
		this.product = p;
		this.amount = a;
	}
	
	public Product getProduct() {
		return this.product;
	}
	
	public int getAmount() {
		return this.amount;
	}
	
	public void removeFromStock(int amount){
		this.amount -= amount;
	}
}
