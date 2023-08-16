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

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        int tamanho, op;
        System.out.println("Tamanho do vetor: ");
        tamanho = scan.nextInt();
        int[] vetor = new int[tamanho];

        op = menuEntrada();
        switch (op) {
            case 1:
                for (int i = 0; i < vetor.length; i++) 
                    vetor[i] = rand.nextInt(100);
                System.out.println("Vetor aleatorio gerado!");
                break;
                
            case 2:
                System.out.println("Dados vetor: ");
                for (int i = 0; i < vetor.length; i++) 
                    vetor[i] = scan.nextInt();
                break;
                
            default:
                System.out.println("Opcao invalida!");
                break;
        }

        System.out.println("Vetor: ");
        printArray(vetor);
        System.out.println("\nVetor Ordenado: ");
        //BubbleSort.bSort(vetor);
        //SelectionSort.sSort(vetor);
        InsertionSort.iSort(vetor);
        printArray(vetor);
    }

    public static void printArray(int array[]) {
        for (int i = 0; i < array.length; i++) 
            System.out.print(array[i] + " | ");    
        System.out.println("\n");
    }

}
