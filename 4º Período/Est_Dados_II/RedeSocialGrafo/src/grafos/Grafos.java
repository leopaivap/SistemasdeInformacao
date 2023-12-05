package grafos;

import java.util.Scanner;

public class Grafos {

    static int menuMetodos() {
        Scanner scanner = new Scanner(System.in);
        int op;
        System.out.println("\n1-Adicionar Usuario");
        System.out.println("2-Adicionar Conexao");
        System.out.println("3-Listar Contatos");
        System.out.println("4-Listar Conexoes de Usuario");
        System.out.println("5-Alcance Contato");
        System.out.println("0-Sair");
        op = scanner.nextInt();
        return op;
    }

    public static void main(String[] args) {
        Graph grafo = new Graph();
        Scanner scanner = new Scanner(System.in);
        int op = 0;
        //grafo.carregarGrafo();

        do {
            op = menuMetodos();
            switch (op) {
                case 1:
                    System.out.println("Usuario:");
                    String nome = scanner.nextLine();
                    grafo.adicionarVertice(nome);
                    break;

                case 2:
                    System.out.println("Conexoes:");
                    String usuario1 = scanner.nextLine();
                    String usuario2 = scanner.nextLine();
                    grafo.adicionarAresta(usuario1, usuario2);
                    break;

                case 3:
                    System.out.println("\n");
                    grafo.imprimirGrafo();
                    System.out.println("\n");
                    break;

                case 4:
                    System.out.println("Contato:");
                    usuario1 = scanner.nextLine();
                    grafo.verificaConexoes(usuario1);
                    break;

                case 5:
                    System.out.println("Contatos");
                    System.out.println("Contato 1:");
                    usuario1 = scanner.nextLine();
                    System.out.println("Contato 2:");
                    usuario2 = scanner.nextLine();

                    if (grafo.alcance(usuario1, usuario2)) {
                        System.out.println("Existe Caminho!");
                    } else {
                        System.out.println("Nao Existe Caminho!");
                    }
                    break;

                case 0:
                    System.out.println("Saindo");
                    grafo.salvarGrafo();
                    break;
            }
        } while (op != 0);

    }

}
