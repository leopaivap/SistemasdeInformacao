package javasorts;

import java.util.Random;
import java.util.Scanner;

public class JavaSorts {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        int tamanho;
        System.out.println("Tamanho do vetor: ");
        tamanho = scan.nextInt();

        int[] vetor = new int[tamanho];
        System.out.println("Dados vetor: ");
        for (int i = 0; i < vetor.length; i++) 
            vetor[i] = scan.nextInt();
        
        System.out.println("Vetor: ");
        printArray(vetor);
        System.out.println("\nVetor Ordenado: ");
        BubbleSort.bSortDec(vetor);
        printArray(vetor);
    }

    public static void printArray(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " | ");
        }
        System.out.println("\n");
    }

}
