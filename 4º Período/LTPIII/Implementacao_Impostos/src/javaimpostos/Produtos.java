package javaimpostos;

import java.util.ArrayList;
import java.util.List;

public class Produtos {
	private String nome;
	private double precoCusto, precoVenda;
	private int margemLucro;

	private List<Impostos> listaImpostosProduto = new ArrayList<>();
	static private List<Produtos> listaProdutos = new ArrayList<>();

	public Produtos(String nome, double precoCusto, int margemLucro, List<Impostos> listaImpostos) {
		this.nome = nome;
		this.precoCusto = precoCusto;
		this.margemLucro = margemLucro;

		for (Impostos imposto : listaImpostos)
			listaImpostosProduto.add(imposto);

		calculaPrecoVenda(this);
		listaProdutos.add(this);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}

	public int getMargemLucro() {
		return margemLucro;
	}

	public void setMargemLucro(int margemLucro) {
		this.margemLucro = margemLucro;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	public List<Impostos> getListaImpostosProduto() {
		return listaImpostosProduto;
	}

	static public void calculaPrecoVenda(Produtos produto) {
		double somaValorImpostos = 0, valorProduto = 0;
		for (Impostos imposto : produto.listaImpostosProduto)
			somaValorImpostos += ((imposto.getTaxa())) * produto.precoCusto;

		valorProduto = produto.precoCusto + somaValorImpostos;
		produto.precoVenda = valorProduto + ((valorProduto * produto.margemLucro) / 100);
	}

	static public void getListaProdutos() {
		int i = 0;
		for (Produtos produto : listaProdutos) {
			System.out
					.println(i + " - " + produto.getNome() + " | R$" + String.format("%.2f", produto.getPrecoVenda()));
			i++;
		}
	}

	static public Produtos getProdutoIndex(int index) {
		if (index >= 0 && index < listaProdutos.size())
			return listaProdutos.get(index);
		else {
			System.out.println("Index Invalido!");
			return null;
		}
	}

	static public void removeProduto(int index) {
		if (index >= 0 && index < listaProdutos.size())
			listaProdutos.remove(index);
		else
			System.out.println("Index Invalido!");
	}

	public void addImpostoProduto(Impostos imposto) {
		listaImpostosProduto.add(imposto);
	}

	public void removeImpostoProduto(Impostos imposto) {
		listaImpostosProduto.remove(imposto);
	}

	static public void atualizaPrecoVenda() {
		for (Produtos produto : listaProdutos)
			calculaPrecoVenda(produto);
	}

}
