package javaimpostos;

import java.util.ArrayList;
import java.util.List;

public class Venda {
	private static List<Produtos> listaCompras = new ArrayList<>();

	public void addProduto(Produtos produto) {
		listaCompras.add(produto);
	}

	public void removeProduto(int index) {
		if (index >= 0 && index < listaCompras.size())
			listaCompras.remove(index);
		else
			System.out.println("Index inválido.");
	}

	public void getListaProdutos() {
		int i = 0;
		for (Produtos produtos : listaCompras) {
			System.out.println(i + " - " + produtos.getNome());
			i++;
		}
		
	}

	public void cancelaVenda() {
		listaCompras.clear();
	}

	public void finalizaCompra() {
		double valorTotal = 0;
		int i = 0;
		for (Produtos produtos : listaCompras) {
			System.out.println("Item " + i + " - " + produtos.getNome() + " - R$" + String.format("%.2f", produtos.getPrecoVenda()));
			valorTotal += produtos.getPrecoVenda();
			i++;
		}
		System.out.println("\nCompra Finalizada!\nValor Total: R$" + String.format("%.2f", valorTotal));
		cancelaVenda();
	}
}
