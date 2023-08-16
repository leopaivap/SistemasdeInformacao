package javasorts;

public class InsertionSort {

    private static void insert(int array[], int i) {
        int eleito = array[i], comp = i - 1;
        while (comp >= 0 && eleito < array[comp]) {
            array[comp + 1] = array[comp];
            comp--;
        }
        //inserindo o eleito na posicao correta
        array[comp + 1] = eleito;
    }

    public static void iSort(int array[]) {
        for (int i = 1; i < array.length; i++) {
            insert(array, i);
        }
    }
}
