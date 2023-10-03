package model;

import java.util.HashMap;
import java.util.Map;

public class DataProducts {

	private static Map<String, String[]> productList = new HashMap<String, String[]>();

	static {
		productList.put("arroz", new String[] { "Arroz", "20" });
		productList.put("feijao", new String[] { "Feijão", "30" });
		productList.put("sal", new String[] { "Sal", "8" });
		productList.put("pao", new String[] { "Pão", "2.5" });

	}

	public static String[] getProductDescription(String key) {
		return productList.get(key);
	}

}
