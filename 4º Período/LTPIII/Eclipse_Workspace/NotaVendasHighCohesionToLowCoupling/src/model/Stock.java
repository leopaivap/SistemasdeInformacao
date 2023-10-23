package model;

import java.util.List;

public class Stock {
	private List<StockItem> items;

	Stock() {
		// recuperar do bd

		items = DataProducts.getStockItems();
	}

public boolean hasAmount(String productId, int amount) {
	Product p = DataProducts.getProduct(productId);
	
	for (StockItem stockItem : items) {
		Product pInStock = stockItem.getProduct();
		
		if(p.getDescription().equals(pInStock.getDescription())) {
			return stockItem.getAmount() >= amount;
			
		}
		return false;
	}
	
	public void removeFromStock(String productId, int amount) {
		
		Product p = DataProducts.getProduct(productId);
		
		for (StockItem stockItem : items) {
			Product pInStock = stockItem.getProduct();
			
			if(p.getDescription().equals(pInStock.getDescription())) {
				stockItem.removeFromStock(amount);
				
			}
			break;
		}
		
	}
	
	return false;
}
}
