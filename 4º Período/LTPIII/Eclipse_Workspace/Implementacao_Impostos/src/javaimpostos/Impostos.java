package javaimpostos;

import java.util.ArrayList;
import java.util.List;

public class Impostos {
	private String nome;
	private double taxa;

	static private List<Impostos> listaImpostos = new ArrayList<>();

	public Impostos(String nome, double taxa) {
		this.nome = nome;
		this.taxa = taxa;

		listaImpostos.add(this);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getTaxa() {
		return taxa;
	}

	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}

	static public Impostos getImpostoIndex(int index) {
		if (index >= 0 && index < listaImpostos.size())
			return listaImpostos.get(index);
		else {
			System.out.println("Index Invalido!");
			return null;
		}
	}

	static public void getListaImpostos() {
		int i = 0;
		for (Impostos imposto : listaImpostos) {
			System.out.println(
					i + " - " + imposto.getNome() + " | " + String.format("%.2f", imposto.getTaxa() * 100) + "%");
			i++;
		}
	}

	static public void getListaImpostosNovos(Produtos produto) {
		int i = 0;
		for (Impostos imposto : listaImpostos) {
			if (!impostoConsta(imposto, produto))
				System.out.println(
						i + " - " + imposto.getNome() + " | " + String.format("%.2f", imposto.getTaxa() * 100) + "%");
			i++;

		}
	}

	static public void getListaImpostosPresentes(Produtos produto) {
		int i = 0;
		for (Impostos imposto : listaImpostos) {
			if (impostoConsta(imposto, produto))
				System.out.println(
						i + " - " + imposto.getNome() + " | " + String.format("%.2f", imposto.getTaxa() * 100) + "%");
			i++;

		}
	}

	private static boolean impostoConsta(Impostos imposto, Produtos produto) {
		for (Impostos imp : produto.getListaImpostosProduto())
			if (imp == imposto)
				return true;
		return false;
	}

	static public void removeImposto(int index) {
		if (index >= 0 && index < listaImpostos.size())
			listaImpostos.remove(index);
		else
			System.out.println("Index Invalido!");
	}

	static public int tamanhoListaImposto() {
		return listaImpostos.size();
	}

}
