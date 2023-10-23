package model;

import java.util.HashMap;
import java.util.Map;

public class DataBase {
	private static Map<String, String[]> products = new HashMap();
	
	private static Map<String, Payment> paymmnets = new HashMap<>();
	
	
	static {
		products.put("arroz", new String[] {"Arroz Tipo 1", "20"});
		products.put("feijao", new String[] {"Feijão Malícia", "30"});
		products.put("sal", new String[] {"Sal Marino", "8"});
		
		Payment credit = new Credit(5);
		
		paymmnets.put("cc", credit);
		paymmnets.put("cd", new Debit(0));
		paymmnets.put("c", new Cash(5));
	}
	
	public static String[] getProductDescription(String key) {
		return products.get(key);
	}
	
	public static Payment getPaymmnet(String key) {
		return paymmnets.get(key);
	}
}
