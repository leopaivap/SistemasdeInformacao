package model;

import java.util.HashMap;
import java.util.Map;

public class DataProducts {

	private static Map<String, String[]> productList = new HashMap<String, String[]>();
	private static Map<String, Payment> payments = new HashMap<>();

	static {
		productList.put("arroz", new String[] { "Arroz", "20" });
		productList.put("feijao", new String[] { "Feijão", "30" });
		productList.put("sal", new String[] { "Sal", "8" });
		productList.put("pao", new String[] { "Pão", "2.5" });

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

}
