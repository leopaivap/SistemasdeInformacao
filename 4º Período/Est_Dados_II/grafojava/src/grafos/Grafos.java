package grafos;

import java.util.List;
import java.util.Scanner;

public class Grafos {

    static int menuMetodos() {
        Scanner scanner = new Scanner(System.in);
        int op;
        System.out.println("1-Adicionar Vertice");
        System.out.println("2-Adicionar Aresta");
        System.out.println("3-Imprime Grafo");
        System.out.println("4-Alcance Grafo");
        System.out.println("5-Busca em Profundidade [DFS]");
        System.out.println("6-Busca em Largura [BFS]");
        System.out.println("0-Sair");
        op = scanner.nextInt();
        return op;
    }

    public static void main(String[] args) {
        Graph grafo = new Graph();
        Scanner scanner = new Scanner(System.in);
        int op = 0;
        grafo.carregarGrafo();

        do {
            op = menuMetodos();
            switch (op) {
                case 1:
                    System.out.println("Vertice:");
                    int valor = scanner.nextInt();
                    grafo.adicionarVertice(valor);
                    break;

                case 2:
                    System.out.println("Adjacencias:");
                    int origem = scanner.nextInt();
                    int destino = scanner.nextInt();
                    System.out.println("Peso:");
                    int peso = scanner.nextInt();
                    grafo.adicionarAresta(origem, destino, peso);
                    grafo.imprimirGrafo();
                    break;

                case 3:
                    grafo.imprimirGrafo();
                    break;

                case 4:
                    System.out.println("Vertices");
                    System.out.println("Origem:");
                    origem = scanner.nextInt();
                    System.out.println("Destino:");
                    destino = scanner.nextInt();

                    if (grafo.alcance(origem, destino)) 
                        System.out.println("Existe Caminho!");
                    else 
                        System.out.println("Nao Existe Caminho!");
                    
                    break;

                case 0:
                    System.out.println("Saindo");
                    grafo.salvarGrafo();
                    break;
            }
        } while (op != 0);

    }

}
