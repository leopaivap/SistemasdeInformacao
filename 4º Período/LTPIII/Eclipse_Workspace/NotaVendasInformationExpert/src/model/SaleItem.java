package model;

public class SaleItem {
	private Product saleProduct;
	private int amount;
	private double totalPriceItem;

	public SaleItem(String productId, int amount) throws Exception {
		String[] product = DataProducts.getProductDescription(productId);

		String prodDesc = product[0];
		double prodPrice = Double.parseDouble(product[1]);

		if (product != null) {
			Product prod = new Product(prodDesc, prodPrice);
			this.saleProduct = prod;
			this.amount = amount;
			this.totalPriceItem = amount * this.getSaleProduct().getCost();
		} else 
			throw new Exception("Produto Inexistente!");			
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
