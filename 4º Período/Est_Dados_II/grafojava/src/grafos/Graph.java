package grafos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

class ComparadorDistancia implements Comparator<No> {

    public int compare(No no1, No no2) {
        return Integer.compare(no1.distancia, no2.distancia);
    }
}

public class Graph {

    private Map<Integer, LinkedList<Aresta>> meuGrafo;
    private ArrayList visitados;

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

    public ArrayList buscaProfundidade(int origem) {
        visitados = new ArrayList();
        explorarDFS(origem);
        return visitados;
    }

    public void explorarDFS(int verticeAtual) {
        visitados.add(verticeAtual);
        LinkedList<Aresta> adjacentes = meuGrafo.get(verticeAtual);
        for (Aresta adj : adjacentes) {
            if (!visitados.contains(adj.vertice)) {
                explorarDFS(adj.vertice);
            }
        }
    }

    public List buscaemLargura(int verticeInicial) {
        Queue<Integer> fila = new LinkedList<>();
        visitados = new ArrayList<>();
        fila.add(verticeInicial);

        while (!fila.isEmpty()) {
            int verticeAtual = fila.poll(); //dequeue
            visitados.add(verticeAtual);
            List<Aresta> vizinhos = meuGrafo.get(verticeAtual);

            for (Aresta adjacente : vizinhos) {
                if (!visitados.contains(adjacente.vertice) && !fila.contains(adjacente.vertice)) {
                    fila.add(adjacente.vertice);
                }
            }
        }
        return visitados;
    }

    public Map<Integer, Integer> dijkstra(int origem) {

        Map<Integer, Integer> distancias = new HashMap<>();
        Map<Integer, Integer> predecessores = new HashMap<>();
        PriorityQueue<No> filaPrioridade = new PriorityQueue<>(new ComparadorDistancia());
        visitados = new ArrayList();

        for (int vertice : meuGrafo.keySet()) {
            distancias.put(vertice, Integer.MAX_VALUE);
            predecessores.put(vertice, null);
        }

        distancias.put(origem, 0);
        filaPrioridade.add(new No(origem, 0));

        // processar o grafo
        while (!filaPrioridade.isEmpty()) {
            int verticeAtual = filaPrioridade.poll().vertice;
            if (!visitados.contains(verticeAtual)) {
                visitados.add(verticeAtual);

                for (Aresta aresta : meuGrafo.get(verticeAtual)) {
                    int vizinho = aresta.vertice;
                    int pesoAresta = aresta.peso;
                    int novaDistancia = distancias.get(verticeAtual) + pesoAresta;

                    if (novaDistancia < distancias.get(vizinho)) {
                        distancias.put(vizinho, novaDistancia);
                        predecessores.put(vizinho, verticeAtual);
                        filaPrioridade.add(new No(vizinho, novaDistancia));
                    }
                }
            }
        }
        return distancias;
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
        try (PrintWriter writer = new PrintWriter(new FileWriter("grafo4.txt"))) {
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
        try (Scanner scanner = new Scanner(new File("grafo4.txt"))) {
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
