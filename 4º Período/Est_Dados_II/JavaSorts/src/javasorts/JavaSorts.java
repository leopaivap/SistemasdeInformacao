package javasorts;

import java.util.Random;
import java.util.Scanner;

public class JavaSorts {

    static int menuEntrada() {
        Scanner scan = new Scanner(System.in);
        int op;
        System.out.println("1- Gerar dados");
        System.out.println("2- Entrar com dados");
        op = scan.nextInt();
        return op;
    }

    static int menuSorts() {
        //limpa tela
        Scanner scan = new Scanner(System.in);
        int op;
        System.out.println("1- Bubble Sort");
        System.out.println("2- Selection Sort");
        System.out.println("3- Insertion Sort");
        /* System.out.println("1- Bubble Sort");
        System.out.println("1- Bubble Sort");
        System.out.println("1- Bubble Sort");
        System.out.println("1- Bubble Sort");
        System.out.println("1- Bubble Sort");
        System.out.println("1- Bubble Sort"); */
        op = scan.nextInt();
        return op;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        int tamanho, op, opSorts;
        long tempoInicial, tempoFinal;
        System.out.println("Tamanho do vetor: ");
        tamanho = scan.nextInt();
        int[] vetor = new int[tamanho];

        op = menuEntrada();
        switch (op) {
            case 1:
                for (int i = 0; i < vetor.length; i++) {
                    vetor[i] = rand.nextInt(100);
                }
                System.out.println("Vetor aleatorio gerado!");
                break;

            case 2:
                System.out.println("Dados vetor: ");
                for (int i = 0; i < vetor.length; i++) {
                    vetor[i] = scan.nextInt();
                }
                break;

            default:
                System.out.println("Opcao invalida!");
                break;
        }

        opSorts = menuSorts();
        switch (opSorts) {
            case 1:
                //Bubble Sort
                tempoInicial = System.currentTimeMillis();
                BubbleSort.bSort(vetor);
                tempoFinal = System.currentTimeMillis();
                System.out.println("Comparações: " + BubbleSort.comparacoes);
                System.out.println("Trocas: " + BubbleSort.trocas);
                System.out.println("Tempo: " + (tempoFinal - tempoInicial) + "ms");
                break;

            case 2:
                //Selection Sort
                tempoInicial = System.currentTimeMillis();
                SelectionSort.sSort(vetor);
                tempoFinal = System.currentTimeMillis();
                System.out.println("Comparações: " + SelectionSort.comparacoes);
                System.out.println("Trocas: " + SelectionSort.trocas);
                System.out.println("Tempo: " + (tempoFinal - tempoInicial) + "ms");
                break;

            case 3:
                //Insertion Sort
                tempoInicial = System.currentTimeMillis();
                InsertionSort.iSort(vetor);
                tempoFinal = System.currentTimeMillis();
                System.out.println("Comparações: " + InsertionSort.comparacoes);
                System.out.println("Deslocamentos: " + InsertionSort.deslocamento);
                System.out.println("Tempo: " + (tempoFinal - tempoInicial) + "ms");
                break;

            default:
                System.out.println("Opcao invalida!");
                break;

        }

        System.out.println("Vetor: ");
        printArray(vetor);
        System.out.println("\nVetor Ordenado: ");
        printArray(vetor);
    }

    public static void printArray(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " | ");
        }
        System.out.println("\n");
    }

}
