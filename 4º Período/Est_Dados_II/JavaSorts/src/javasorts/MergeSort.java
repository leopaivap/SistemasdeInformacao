package javasorts;

import java.util.Scanner;

public class MergeSort {

    public static void mergeSort(int[] vetor, int[] auxiliar, int inicio, int fim) {

        if (inicio < fim) {

            //Achar o meio do vetor 
            int meio = (inicio + fim) / 2;
            //chamando o lado esquerdo do inicio ao meio do vetor
            mergeSort(vetor, auxiliar, inicio, meio);
            //chamando o lado direito do meio ao fim do vetor
            mergeSort(vetor, auxiliar, meio + 1, fim);
            //junção dos vetores comparando eles
            intercalar(vetor, auxiliar, inicio, meio, fim);
        }

    }

    public static void intercalar(int[] vetor, int[] auxiliar, int inicio, int meio, int fim) {

        //percorre todo o vetor
        for (int i = inicio; i <= fim; i++) {
            auxiliar[i] = vetor[i];//preenchendo o vetor auxiliar
        }

        //indicies para trabalhar com as partes esquerda e direita do vetor     
        int esq = inicio;
        int dir = meio + 1;

        //percorre todo o vetor
        for (int i = inicio; i <= fim; i++) {
            if (esq > meio) {
                vetor[i] = auxiliar[dir++];
            } else if (dir > fim) {
                vetor[i] = auxiliar[esq++];
            } else if (auxiliar[esq] < auxiliar[dir]) //se o numero da esquerda for menor q o numero da direitra
            {
                vetor[i] = auxiliar[esq++];
            } else//se o numero da esquerda for maior q o numero da direitra
            {
                vetor[i] = auxiliar[dir++];
            }

        }
    }

    public static void printArray(int array[]) {

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "| ");
        }

        System.out.println("\n");

    }// fim printArray  

    public static void mergeSortComentado(int[] vetor, int[] auxiliar, int inicio, int fim) {

        if (inicio < fim) {
            //Achar o meio do vetor 
            int meio = (inicio + fim) / 2;
            //chamando o lado esquerdo do inicio ao meio do vetor
            mergeSortComentado(vetor, auxiliar, inicio, meio);
            //chamando o lado direito do meio ao fim do vetor
            mergeSortComentado(vetor, auxiliar, meio + 1, fim);
            //junção dos vetores comparando eles
            intercalarComentado(vetor, auxiliar, inicio, meio, fim);
            System.out.println("");

        }

    }

    public static void intercalarComentado(int[] vetor, int[] auxiliar, int inicio, int meio, int fim) {
        Scanner scanner = new Scanner(System.in);

        for (int i = inicio; i <= fim; i++) {
            auxiliar[i] = vetor[i];//preenchendo o vetor auxiliar
        }

        //indicies para trabalhar com as partes esquerda e direita do vetor     
        int esq = inicio;
        int dir = meio + 1;

        //percorre todo o vetor
        System.out.println("Ordenando");
        for (int i = inicio; i <= fim; i++) {

            int k = 1;

            if (esq > meio) {
                System.out.println("1  O vetor " + auxiliar[esq] + " é MAIOR que o vetor " + vetor[meio]);
                vetor[i] = auxiliar[dir++];
            } else if (dir > fim) {
                System.out.println("2  O vetor " + auxiliar[dir] + " é MAIOR que o vetor " + auxiliar[esq]);
                vetor[i] = auxiliar[esq++];
            } else if (auxiliar[esq] < auxiliar[dir]) {//se o numero da esquerda for menor q o numero da direitra
                System.out.println("3  O vetor na posição esqueda " + auxiliar[esq] + " é MENOR que o vetor " + auxiliar[dir]);
                vetor[i] = auxiliar[esq++];
            } else {//se o numero da esquerda for maior q o numero da direitra
                System.out.println("4  O vetor na posição esqueda " + auxiliar[esq] + " é MAIOR que o vetor " + auxiliar[dir]);
                vetor[i] = auxiliar[dir++];
            }

        }
        System.out.println("---------------------------------");
        printArray(auxiliar);
        scanner.nextLine();// pause
    }
}

