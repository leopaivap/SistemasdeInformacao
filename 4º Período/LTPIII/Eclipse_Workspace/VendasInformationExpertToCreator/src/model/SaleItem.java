package model;

public class SaleItem {
	private Product product;
	private int amount;
	
	public SaleItem(String productCode, int amount) {
		// Precisamos da descrição e do preço do produto
		String[] prodDesc = DataBase.getProductDescription(productCode);
		
		String productDescription = prodDesc[0];
		double productPrice = Double.parseDouble(prodDesc[1]);
		
		this.product = new Product(productDescription, productPrice);
		this.amount = amount;
	}
	
	public Product getProduct() {
		return this.product;
	}
	
	public int getAmount() {
		return this.amount;
	}
	
	public double getSaleItemSubTotal() {
		return this.amount * this.product.getPrice();
	}
}
