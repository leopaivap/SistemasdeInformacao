package model;

import java.util.List;

public class Stock {
	private List<StockItem> items;
	
	public Stock() {
		// Vamos recuperar do BD
		items = DataBase.stokItems();
	}
	
	public boolean hasAmount(String codProduct, int amount) {
		Product p = DataBase.getProduct(codProduct);
		
		
		for (StockItem stockItem : items) {
			Product pInStock = stockItem.getProduct();
			
			if (p.getDescription().equals(pInStock.getDescription())) {
				return stockItem.getAmount() >= amount;
			}
		}
		
		return false;
	}
	
	
	public void removeFromStock(String codProduct, int amount) {
		Product p = DataBase.getProduct(codProduct);
		
		
		for (StockItem stockItem : items) {
			Product pInStock = stockItem.getProduct();
			
			if (p.getDescription().equals(pInStock.getDescription())) {
				stockItem.removeFromStock(amount);
			}
			
			break;
		}
	}
}
