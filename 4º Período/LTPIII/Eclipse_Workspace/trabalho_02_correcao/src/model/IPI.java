package model;

public class IPI extends Tax {

	// Imagine que isso viesse de um BD
	private static final double FOREIGN_ALIQUOT = 10;
	private static final double LOCAL_ALIQUOT = 8;

	public IPI() throws Exception {
		super("IPI", "Imposto Prod. Insdustrializado");
	}

	@Override
	public double calculate(Product p) {
		double ipiCost = p.getCostPrice() * getAliquot();
		return ipiCost;
	}

	@Override
	public void defineAliquot(Product p) {
		if (p.isForeign())
			setAliquot(FOREIGN_ALIQUOT);
		else
			setAliquot(LOCAL_ALIQUOT);

	}
}
