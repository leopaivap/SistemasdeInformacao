package grafos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Graph {

    private Map<Integer, LinkedList<Aresta>> meuGrafo;

    public Graph() {
        this.meuGrafo = new HashMap<>();
    }

    // Método para adicionar um vértice ao grafo
    public void adicionarVertice(int vertice) {
        if (!meuGrafo.containsKey(vertice)) {
            meuGrafo.put(vertice, new LinkedList<>());
        }
    }

    public void adicionarAresta(int origem, int destino, int peso) {
        if (!meuGrafo.containsKey(origem) || !meuGrafo.containsKey(destino)) {
            throw new IllegalArgumentException("Os vértices de origem e destino devem existir no grafo.");
        }

        meuGrafo.get(origem).add(new Aresta(destino, peso));
        //listaAdjacencia.get(destino).add(new Aresta(origem, peso));

    }

    public boolean alcance(int origem, int destino) {
        ArrayList visitados = new ArrayList();
        return existeCaminho(origem, destino, visitados);
    }

    private boolean existeCaminho(int verticeAtual, int destino, ArrayList visitados) {
        if (verticeAtual == destino) {
            System.out.println("Caminho: " + visitados);
            return true;
        }

        visitados.add(verticeAtual);
        LinkedList<Aresta> adjacencias = meuGrafo.get(verticeAtual);

        if (adjacencias != null) {
            for (Aresta vizinho : adjacencias) {
                if (!visitados.contains(vizinho.vertice) && existeCaminho(vizinho.vertice, destino, visitados)) {
                    return true;
                }
            }
        }
        System.out.println("Caminho: " + visitados);
        return false;
    }

    public void imprimirGrafo() {
        for (Map.Entry<Integer, LinkedList<Aresta>> entry : meuGrafo.entrySet()) {
            int vertice = entry.getKey();
            LinkedList<Aresta> vizinhos = entry.getValue();
            System.out.print(vertice + " -> ");
            for (Aresta vizinho : vizinhos) {
                System.out.print(vizinho.vertice + "[" + vizinho.peso + "]" + " ");
            }
            System.out.println();
        }
    }

    public void salvarGrafo() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("grafo.txt"))) {
            for (Map.Entry<Integer, LinkedList<Aresta>> entry : meuGrafo.entrySet()) {
                int vertice = entry.getKey();
                LinkedList<Aresta> vizinhos = entry.getValue();
                for (Aresta vizinho : vizinhos) {
                    writer.println(vertice + " " + vizinho.vertice + " " + vizinho.peso);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para carregar os dados do grafo de um arquivo texto
    public void carregarGrafo() {
        try (Scanner scanner = new Scanner(new File("grafo.txt"))) {
            while (scanner.hasNext()) {
                int origem = scanner.nextInt();
                int destino = scanner.nextInt();
                int peso = scanner.nextInt();

                adicionarVertice(origem);
                adicionarVertice(destino);
                adicionarAresta(origem, destino, peso);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
