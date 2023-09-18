package model;

public abstract class Tax {

	private String abbr, name;
	private double aliquot;

	public Tax(String abbr, String name) throws Exception {
		setAbbr(abbr);
		setName(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Tax))
			return false;

		Tax tax = (Tax) obj;

		return this.abbr.equals(tax.abbr);
	}

	protected abstract double calculate(Product p);

	protected abstract void defineAliquot(Product p);

	protected void setAliquot(double aliquot) {
		this.aliquot = aliquot / 100;
	}

	protected double getAliquot() {
		return this.aliquot;
	}

	private void setName(String name) throws Exception {

		if (name == null || name.equals(""))
			throw new Exception("Nome Inválido!");

		this.name = name;
	}

	private void setAbbr(String abbr) throws Exception {

		if (abbr == null || abbr.equals(""))
			throw new Exception("Sigla Inválida!");

		this.abbr = abbr;
	}
}