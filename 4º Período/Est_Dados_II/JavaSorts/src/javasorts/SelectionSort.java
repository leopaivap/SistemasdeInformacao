package javasorts;

public class SelectionSort {

    private static int indexMinArray(int array[], int posAtual) {
        int k = posAtual;
        for (int i = posAtual + 1; i < array.length; i++) 
            if (array[i] < array[k]) 
                k = i;
        return k; // indice do menor valor
    }

    public static void sSort(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            int k = indexMinArray(array, i);

            //trocar valores de i com k
            int temp = array[i];
            array[i] = array[k];
            array[k] = temp;
        }
    }
}
