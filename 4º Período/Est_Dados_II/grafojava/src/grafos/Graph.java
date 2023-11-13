package grafos;

import java.util.*;

public class Graph {

    private Map<Integer, LinkedList<Aresta>> listaAdjacencia;

    public Graph() {
        this.listaAdjacencia = new HashMap<>();
    }

    // Método para adicionar um vértice ao grafo
    public void adicionarVertice(int vertice) {
        if (!listaAdjacencia.containsKey(vertice)) {
            listaAdjacencia.put(vertice, new LinkedList<>());
        }
    }

    public void adicionarAresta(int origem, int destino, int peso) {
        if (!listaAdjacencia.containsKey(origem) || !listaAdjacencia.containsKey(destino)) {
            throw new IllegalArgumentException("Os vértices de origem e destino devem existir no grafo.");
        }

        listaAdjacencia.get(origem).add(new Aresta(destino, peso));
        listaAdjacencia.get(destino).add(new Aresta(origem, peso)); //grafo nao direcionado
    }

    public void imprimirGrafo() {
        for (Map.Entry<Integer, LinkedList<Aresta>> entry : listaAdjacencia.entrySet()) {
            int vertice = entry.getKey();
            LinkedList<Aresta> vizinhos = entry.getValue();
            System.out.print(vertice + " -> ");
            for (Aresta vizinho : vizinhos) {
                System.out.print(vizinho.vertice + "[" + vizinho.peso + "]" + " ");
            }
            System.out.println();
        }
    }

}
