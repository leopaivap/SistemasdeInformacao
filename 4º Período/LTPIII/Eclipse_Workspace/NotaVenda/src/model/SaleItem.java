package model;

public class SaleItem {
	private Product saleProduct;
	private int amount;
	private double totalPriceItem;

	public SaleItem(Product prod, int amount) throws Exception {
		if (Product.stockValidate(prod, amount)) {
			this.saleProduct = prod;
			this.amount = amount;
			totalPriceItem = prod.getCost() * amount;
		}

	}

	public Product getSaleProduct() {
		return saleProduct;
	}

	public int getAmount() {
		return amount;
	}

	public double getTotalPriceItem() {
		return totalPriceItem;
	}

}
