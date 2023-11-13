package grafos;

public class Grafos {

    public static void main(String[] args) {
        Graph grafo = new Graph();
        grafo.adicionarVertice(1);
        grafo.adicionarVertice(2);
        grafo.adicionarVertice(3);
        grafo.adicionarVertice(4);

        grafo.adicionarAresta(1, 2, 3);
        grafo.adicionarAresta(1, 3, 5);
        grafo.adicionarAresta(2, 4, 2);
        grafo.adicionarAresta(3, 4, 1);

        grafo.imprimirGrafo();

    }

}
