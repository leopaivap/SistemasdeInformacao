package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBase {
	private static Map<String, String[]> products = new HashMap<String, String[]>();
	
	private static Map<String, Paymmnet> paymmnets = new HashMap<>();
	
	private static Map<String, StockItem> stockItems = new HashMap<>();
	
	
	static {
		products.put("arroz", new String[] {"Arroz Tipo 1", "20"});
		products.put("feijao", new String[] {"Feijão Malícia", "30"});
		products.put("sal", new String[] {"Sal Marino", "8"});
		
		stockItems.put("arroz", new StockItem(new Product("Arroz Tipo 1", 20), 5));
		stockItems.put("feijao", new StockItem(new Product("Feijão Malícia", 30), 5));
		stockItems.put("sal", new StockItem(new Product("Sal Marino", 8), 5));
		
		Paymmnet credit = new Credit(5);
		
		paymmnets.put("cc", credit);
		paymmnets.put("cd", new Debit(0));
		paymmnets.put("c", new Cash(5));
	}
	
	public static List<StockItem> stokItems(){
		
		List<StockItem> items = new ArrayList<>();
		
		for (StockItem stockItem : stockItems.values()) {
			items.add(stockItem);
		}
		
		return items;
	}
	
	public static String[] getProductDescription(String key) {
		return products.get(key);
	}
	
	public static Paymmnet getPaymmnet(String key) {
		return paymmnets.get(key);
	}
	
	public static Product getProduct(String codProduct) {
		String[] dataProduct = products.get(codProduct);
		
		
		if (dataProduct != null) {
			Product p = new Product(dataProduct[0], 
					Double.parseDouble(dataProduct[1]));
			
			return p;
		}
		
		return null;
	}
}
