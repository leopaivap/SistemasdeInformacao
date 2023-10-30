package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SaleManager {
	private Stock stock;
	private Sale sale;
	
	public SaleManager() {
		stock = new Stock();
		sale = null;
	}
	
	public void openSale() {
		sale = new Sale();
	}
	
	public void closeSale() {
		sale = null;
	}
	
	public boolean isOpen() {
		return sale != null;
	}
	
	public boolean addItem(String codProduct, int amount) {
		
		if (!isOpen())
			return false;
		
		// Se tem no estoque
		if (stock.hasAmount(codProduct, amount)) {		
			sale.addItem(codProduct, amount);
			stock.removeFromStock(codProduct, amount);
			return true;
		}
		
		return false;
	}
	
	public void addPaymment(String paymment){
		if (isOpen())
			sale.addPaymment(paymment);
	}

	public Date getDate() {
		if (isOpen())
			return sale.getDate();
		
		return null;
	}

	public List<String> getSaleItems() {		
		if (isOpen())
			return sale.getSaleItems();
		
		return new ArrayList<>();
	}

	public double getTotal() {
		if (isOpen())
			return sale.getTotal();
		
		return 0.0;
	}

	public String getPaymment() {
		if (isOpen())
			return sale.getPaymment();
		
		return "";
	}

	public double paymmentValue() {
		if (isOpen())
			return sale.paymmentValue();
		
		return 0.00;
	}
}
