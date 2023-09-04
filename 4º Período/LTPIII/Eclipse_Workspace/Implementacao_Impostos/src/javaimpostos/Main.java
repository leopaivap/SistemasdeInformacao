package javaimpostos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int menu() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Produto: ");
		System.out.println("   1- Adicionar Produto");
		System.out.println("   2- Remover Produto");
		System.out.println("   3- Alterar Margem de Lucro");
		System.out.println("   4- Listar Produtos");
		System.out.println("   5- Adicionar Imposto ao Produto");
		System.out.println("   6- Remover Imposto do Produto");

		System.out.println("\nImposto: ");
		System.out.println("   7- Adicionar Imposto");
		System.out.println("   8- Remover Imposto");
		System.out.println("   9- Listar Impostos");
		System.out.println("   10- Alterar Imposto");

		System.out.println("\nVenda:");
		System.out.println("   11- Adicionar Produto ao Carrinho");
		System.out.println("   12- Remover Produto do Carrinho");
		System.out.println("   13- Carrinho");
		System.out.println("   14- Finalizar Compra");
		System.out.println("   15- Cancelar Compra");

		System.out.println("\n   0- Sair");

		System.out.println("Digite uma Opcao: ");

		int op = scan.nextInt();
		return op;
	}

	public static void main(String[] args) {
		int op, margemLucro, escolhido, produtoEscolhido, impostoEscolhido;
		String nome;
		double precoCusto, taxa;
		boolean escolheu;

		List<Impostos> listaImpostosEscolhidos = new ArrayList<>();

		Scanner scan = new Scanner(System.in);
		Venda venda = new Venda();

		// Instanciando os dados da atividade
		Impostos icms = new Impostos("ICMS", 0.07);
		Impostos confins = new Impostos("Confins", 0.12);
		Impostos ipi = new Impostos("IPI", 0.08);
		Impostos iss = new Impostos("ISS", 0.05);
		Impostos cide = new Impostos("Cide", 0.1);
		Impostos csll = new Impostos("CSLL", 0.04);

		// Arroz
		List<Impostos> listaImpostosArroz = new ArrayList<>();
		listaImpostosArroz.add(icms);
		listaImpostosArroz.add(iss);
		listaImpostosArroz.add(confins);
		Produtos arroz = new Produtos("Arroz", 7, 20, listaImpostosArroz);
		// Feijão
		Produtos feijao = new Produtos("Feijao", 7, 25, listaImpostosArroz);

		// Carne
		List<Impostos> listaImpostosCarne = new ArrayList<>();
		listaImpostosCarne.add(icms);
		listaImpostosCarne.add(ipi);
		listaImpostosCarne.add(confins);
		Produtos carne = new Produtos("Carne", 7, 35, listaImpostosCarne);

		// Cerveja
		List<Impostos> listaImpostosCerveja = new ArrayList<>();
		listaImpostosCerveja.add(icms);
		listaImpostosCerveja.add(ipi);
		listaImpostosCerveja.add(confins);
		listaImpostosCerveja.add(iss);
		Produtos cerveja = new Produtos("Cerveja", 7, 30, listaImpostosCarne);

		// Gás
		Produtos gas = new Produtos("Gás", 7, 15, listaImpostosCarne);

		// Gasolina
		List<Impostos> listaImpostosGasolina = new ArrayList<>();
		listaImpostosGasolina.add(icms);
		listaImpostosGasolina.add(cide);
		listaImpostosGasolina.add(confins);
		Produtos gasolina = new Produtos("Gasolina", 7, 15, listaImpostosGasolina);

		do {

			op = menu();
			listaImpostosEscolhidos.clear();

			switch (op) {
			case 1:
				System.out.println("Nome do novo Produto: ");
				nome = scan.nextLine();
				System.out.println("Preco de Custo do novo Produto: ");
				precoCusto = scan.nextDouble();
				System.out.println("Margem de Lucro do novo Produto: ");
				margemLucro = scan.nextInt();

				Impostos.getListaImpostos();
				System.out.println(
						"\nInforme os Impostos:\nObs: Para finalizar a selecao digite um numero que nao consta na lista");
				do {
					escolhido = scan.nextInt();

					if (escolhido > Impostos.tamanhoListaImposto())
						escolheu = false;
					else {
						escolheu = true;
						listaImpostosEscolhidos.add(Impostos.getImpostoIndex(escolhido));
					}

				} while (escolheu);
				Produtos novoProduto = new Produtos(nome, precoCusto, margemLucro, listaImpostosEscolhidos);
				break;

			case 2:
				Produtos.getListaProdutos();
				System.out.println("Numero do produto a remover: ");
				escolhido = scan.nextInt();
				Produtos.removeProduto(escolhido);
				System.out.println("Produto removido com sucesso!");
				break;

			case 3:
				Produtos.getListaProdutos();
				System.out.println("Numero do produto a alterar: ");
				escolhido = scan.nextInt();
				System.out.println("Nova Margem de Lucro: ");
				margemLucro = scan.nextInt();
				Produtos.getProdutoIndex(escolhido).setMargemLucro(margemLucro);
				System.out.println("Margem de Lucro Alterada com Sucesso!");
				Produtos.atualizaPrecoVenda();
				break;

			case 4:
				System.out.println("Lista de Produtos:");
				Produtos.getListaProdutos();
				break;

			case 5:
				System.out.println("Selecione um Produto: ");
				Produtos.getListaProdutos();
				produtoEscolhido = scan.nextInt();
				System.out.println("Produto escolhido: " + Produtos.getProdutoIndex(produtoEscolhido).getNome());
				Impostos.getListaImpostosNovos(Produtos.getProdutoIndex(produtoEscolhido));
				System.out.println(
						"\nInforme os Impostos:\nObs: Para finalizar a selecao digite um numero que nao consta na lista(considerando já presentes)");
				do {
					escolhido = scan.nextInt();

					if (escolhido > Impostos.tamanhoListaImposto())
						escolheu = false;
					else {
						escolheu = true;
						Produtos.getProdutoIndex(produtoEscolhido)
								.addImpostoProduto(Impostos.getImpostoIndex(escolhido));
					}

				} while (escolheu);
				Produtos.calculaPrecoVenda(Produtos.getProdutoIndex(produtoEscolhido));
				break;

			case 6:
				System.out.println("Selecione um Produto: ");
				Produtos.getListaProdutos();
				produtoEscolhido = scan.nextInt();
				System.out.println("Produto escolhido: " + Produtos.getProdutoIndex(produtoEscolhido));
				Impostos.getListaImpostosPresentes(Produtos.getProdutoIndex(produtoEscolhido));
				System.out.println(
						"\nInforme os Impostos:\nObs: Para finalizar a selecao digite um numero que nao consta na lista(considerando já presentes)");
				do {
					escolhido = scan.nextInt();

					if (escolhido > Impostos.tamanhoListaImposto())
						escolheu = false;
					else {
						escolheu = true;
						Produtos.getProdutoIndex(produtoEscolhido)
								.removeImpostoProduto(Impostos.getImpostoIndex(escolhido));
					}

				} while (escolheu);
				Produtos.calculaPrecoVenda(Produtos.getProdutoIndex(produtoEscolhido));
				break;

			case 7:
				System.out.println("Nome novo Imposto: ");
				nome = scan.nextLine();
				System.out.println("Taxa novo Imposto: ");
				taxa = scan.nextDouble();
				Impostos novoImposto = new Impostos(nome, taxa);
				System.out.println("Imposto adicionado com sucesso!");
				break;

			case 8:
				Impostos.getListaImpostos();
				System.out.println("Imposto a ser Removido: ");
				impostoEscolhido = scan.nextInt();
				Impostos.removeImposto(impostoEscolhido);
				System.out.println("Imposto removido com sucesso!");
				break;

			case 9:
				System.out.println("Lista de Impostos:");
				Impostos.getListaImpostos();
				break;

			case 10:
				Impostos.getListaImpostos();
				System.out.println("Imposto a ser Alterado: ");
				impostoEscolhido = scan.nextInt();
				System.out.println("Nova Taxa: ");
				taxa = scan.nextDouble();
				Impostos.getImpostoIndex(impostoEscolhido).setTaxa(taxa);
				System.out.println("Imposto alterado com sucesso!");
				Produtos.atualizaPrecoVenda();
				break;

			case 11:
				Produtos.getListaProdutos();
				System.out.println("Produto a ser adicionado:");
				produtoEscolhido = scan.nextInt();
				venda.addProduto(Produtos.getProdutoIndex(produtoEscolhido));
				System.out.println("Produto adicionado ao carrinho!");
				break;

			case 12:
				venda.getListaProdutos();
				System.out.println("Produto a ser removido:");
				produtoEscolhido = scan.nextInt();
				venda.removeProduto(produtoEscolhido);
				break;

			case 13:
				System.out.println("Carrinho de Compras:");
				venda.getListaProdutos();
				break;

			case 14:
				venda.finalizaCompra();
				break;

			case 15:
				venda.cancelaVenda();
				System.out.println("Compra Cancelada!");
				break;

			case 0:
				System.out.println("Saindo...");
				break;

			default:
				System.out.println("Opcao Invalida!");
				break;

			}
			if( op != 0) {
				System.out.println("\n\nPressione um botao para continuar...");
				scan.nextLine();
			}	
		} while (op != 0);

	}
}
