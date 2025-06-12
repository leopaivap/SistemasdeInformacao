package agjava2025;

import java.io.*;
import java.util.*;

public class AGBruteForce {

    private double capacidade;
    private ArrayList<Produto> produtos = new ArrayList<>();
    private int melhorValor = 0;
    private ArrayList<Integer> melhorSolucao = new ArrayList<>();

    public AGBruteForce(double capacidade) {
        this.capacidade = capacidade;
    }

    public void carregaArquivo(String fileName) {
        String line = "";
        String[] produto = null;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                produto = line.split(",");
                Produto novoProduto = new Produto();
                novoProduto.setDescricao(produto[0]);
                novoProduto.setPeso(Double.parseDouble(produto[1]));
                novoProduto.setValor(Double.parseDouble(produto[2]));
                produtos.add(novoProduto);
            }
            System.out.println("Total de produtos carregados: " + produtos.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void resolver() {
        int n = produtos.size();
        int totalCombinacoes = (int) Math.pow(2, n);

        for (int i = 0; i < totalCombinacoes; i++) {
            ArrayList<Integer> solucao = new ArrayList<>();
            double pesoTotal = 0;
            double valorTotal = 0;

            for (int j = 0; j < n; j++) {
                // Verifica se o j-ésimo bit de i está ativado (leva o item j)
                if ((i & (1 << j)) != 0) {
                    solucao.add(1);
                    pesoTotal += produtos.get(j).getPeso();
                    valorTotal += produtos.get(j).getValor();
                } else {
                    solucao.add(0);
                }
            }

            if (pesoTotal <= capacidade && valorTotal > melhorValor) {
                melhorValor = (int) valorTotal;
                melhorSolucao = solucao;
            }
        }

        mostrarMelhorSolucao();
    }

    public void mostrarMelhorSolucao() {
        System.out.println("\n--- Melhor solução encontrada (força bruta) ---");
        System.out.println("Valor total: " + melhorValor);
        System.out.println("Itens levados:");
        for (int i = 0; i < melhorSolucao.size(); i++) {
            if (melhorSolucao.get(i) == 1) {
                Produto p = produtos.get(i);
                System.out.println(p.getDescricao() + " - Valor: " + p.getValor() + " - Peso: " + p.getPeso());
            }
        }
    }
}
