package agjava2025;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AlgoritmoGenerico {
    private int tamanhoCromossomo;
    private int numeroGeracoes;
    private int tamanhoPopulacao;
    private int probabilidadeMutacao;
    private int quantidadeCruzamentos;
    private double capacidadeMochila;

    private ArrayList<Produto> produtos = new ArrayList<Produto>();

    public AlgoritmoGenerico(int numeroGeracoes, int tamanhoPopulacao, int probabilidadeMutacao,
            int quantidadeCruzamentos, double capacidadeMochila) {
        this.capacidadeMochila = capacidadeMochila;
        this.numeroGeracoes = numeroGeracoes;
        this.tamanhoPopulacao = tamanhoPopulacao;
        this.probabilidadeMutacao = probabilidadeMutacao;
        this.quantidadeCruzamentos = quantidadeCruzamentos;
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
            this.tamanhoCromossomo = produtos.size();
            System.out.println("Total de produtos carregados: " + produtos.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
