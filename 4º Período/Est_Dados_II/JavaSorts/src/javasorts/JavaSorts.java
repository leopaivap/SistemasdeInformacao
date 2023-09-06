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
        System.out.println("-- Metodos de Ordenacao --");
        System.out.println("1- Bubble Sort");
        System.out.println("2- Selection Sort");
        System.out.println("3- Insertion Sort");
        System.out.println("4- Linear Search");
        System.out.println("5- Binary Search");
        System.out.println("0- Sair");
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

        int tamanho, op, opSorts, valorBusca;
        long tempoInicial, tempoFinal;
        System.out.println("Tamanho do vetor: ");
        tamanho = scan.nextInt();
        int[] vetor = new int[tamanho];
        int[] array = vetor.clone();
        
        // vetores para mergesort
        int[] vetorPrincipal = new int[tamanho];
        int[] vetorAux = new int[vetorPrincipal.length];
        
        /*
        //MergeSort   
        long tempoInicialMergeSort = System.nanoTime();   

        MergeSort.mergeSort(vetorPrincipal, vetorAux, 0, vetorPrincipal.length-1);

        long tempoFinalMergeSort = System.nanoTime();
        long tempoExecucaoNanosMergeSort = tempoFinalMergeSort - tempoInicialMergeSort;
        double tempoExecucaoSegundosMergeSort = tempoExecucaoNanosMergeSort / 1e9; // Convertendo para segundos

        System.out.println("\nTempo de execução: " + tempoExecucaoSegundosMergeSort + " segundos\n");
        */

        op = menuEntrada();
        switch (op) {
            case 1:
                for (int i = 0; i < vetor.length; i++) {
                    vetor[i] = rand.nextInt(100);
                }
                System.out.println("Vetor aleatorio gerado!\n");
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
        do {
            array = vetor.clone();
            opSorts = menuSorts();

            switch (opSorts) {
                case 1:
                    //Bubble Sort
                    tempoInicial = System.currentTimeMillis();
                    BubbleSort.bSort(array);
                    tempoFinal = System.currentTimeMillis();
                    System.out.println("\n-- Bubble Sort --");
                    System.out.println("Comparações: " + BubbleSort.comparacoes);
                    System.out.println("Trocas: " + BubbleSort.trocas);
                    System.out.println("Tempo: " + (tempoFinal - tempoInicial) + "ms\n");
                    break;

                case 2:
                    //Selection Sort
                    tempoInicial = System.currentTimeMillis();
                    SelectionSort.sSort(array);
                    tempoFinal = System.currentTimeMillis();
                    System.out.println("\n-- Selection Sort --");
                    System.out.println("Comparações: " + SelectionSort.comparacoes);
                    System.out.println("Trocas: " + SelectionSort.trocas);
                    System.out.println("Tempo: " + (tempoFinal - tempoInicial) + "ms\n");
                    break;

                case 3:
                    //Insertion Sort
                    tempoInicial = System.currentTimeMillis();
                    InsertionSort.iSort(array);
                    tempoFinal = System.currentTimeMillis();
                    System.out.println("\n-- Insertion Sort --");
                    System.out.println("Comparações: " + InsertionSort.comparacoes);
                    System.out.println("Deslocamentos: " + InsertionSort.deslocamento);
                    System.out.println("Tempo: " + (tempoFinal - tempoInicial) + "ms\n");
                    break;

                case 4:
                    System.out.println("Valor para Busca Linear: ");
                    valorBusca = scan.nextInt();
                    if (Search.linearSearch(array, valorBusca)) {
                        System.out.println("Valor Encontrado!");
                        System.out.println("Comparacoes: " + Search.compLinear);
                    } else {
                        System.out.println("Valor Inexistente!");
                    }
                    break;

                case 5:
                    System.out.println("Valor para Busca Binaria: ");
                    valorBusca = scan.nextInt();
                    InsertionSort.iSort(array);
                    if (Search.binarySearch(array, valorBusca)) {
                        System.out.println("Valor Encontrado!");
                        System.out.println("Comparacoes: " + Search.compBinaria);
                    } else {
                        System.out.println("Valor Inexistente!");
                    }
                    break;

                case 10:
                    // Implementar comparacao de metodos de ordenacao10

                    break;

                default:
                    System.out.println("Opcao invalida!");
                    break;

            }

            /*System.out.println("Vetor: ");
            printArray(vetor);
            System.out.println("\nVetor Ordenado: ");
            printArray(array);*/
        } while (opSorts != 0);

    }

    public static void printArray(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " | ");
        }
        System.out.println("\n");
    }
    
    public static void printInterval(int array[], int ini, int fim) {
        for (int i = ini; i <= fim; i++) {
            System.out.print(array[i] + " | ");
        }
        System.out.println("\n");
    }

}
