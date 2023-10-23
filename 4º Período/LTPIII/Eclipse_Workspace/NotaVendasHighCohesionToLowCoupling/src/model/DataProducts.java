package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProducts {

	private static Map<String, String[]> productList = new HashMap<String, String[]>();
	private static Map<String, Payment> payments = new HashMap<>();
	private static Map<String, StockItem> stockItems = new HashMap<>();

	static {
		productList.put("arroz", new String[] { "Arroz", "20" });
		productList.put("feijao", new String[] { "Feijão", "30" });
		productList.put("sal", new String[] { "Sal", "8" });
		productList.put("pao", new String[] { "Pão", "2.5" });

		try {
			stockItems.put("arroz", new StockItem(new Product("Arroz", 20), 5));
			stockItems.put("feijao", new StockItem(new Product("Feijão", 30), 5));
			stockItems.put("sal", new StockItem(new Product("Sal", 8), 5));
			stockItems.put("pao", new StockItem(new Product("Pão", 2.5), 5));
		} catch (Exception e) {
			e.printStackTrace();
		}

		payments.put("cc", new Credit(5));
		payments.put("cd", new Debit(0));
		payments.put("c", new Cash(5));

	}

	public static String[] getProductDescription(String key) {
		return productList.get(key);
	}

	public static Payment getPayment(String key) {
		return payments.get(key);
	}

	public static List<StockItem> getStockItems() {
		List<StockItem> itens = new ArrayList<>();

		for (StockItem stockItem : stockItems.values()) {
			itens.add(stockItem);
		}
		return itens;
	}

	public static Product getProduct(String productId) throws Exception {
		String[] dataProduct = productList.get(productId);

		if (dataProduct != null) {
			Product p = new Product(dataProduct[0], Integer.getInteger(dataProduct[1]));
			return p;
		}
	}

}
