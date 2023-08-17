package javasorts;

public class BubbleSort {

    public static long comparacoes = 0, trocas = 0;
    
    public static void bSort(int array[]) {
        for (int fase = 1; fase < array.length; fase++) {
            boolean comparou = false;
            for (int comp = 0; comp < (array.length - fase); comp++) {
                comparacoes++;
                if (array[comp] > array[comp + 1]) {
                    int aux = array[comp];
                    array[comp] = array[comp + 1];
                    array[comp + 1] = aux;

                    comparou = true;
                    trocas++;
                }
            }
            if (!comparou) 
                break;     
        }
    }

    public static void bSortDec(int array[]) {
        for (int fase = 1; fase < array.length; fase++) {
            boolean comparou = false;
            for (int comp = 0; comp < (array.length - fase); comp++) {
                if (array[comp] < array[comp + 1]) {
                    int aux = array[comp];
                    array[comp] = array[comp + 1];
                    array[comp + 1] = aux;

                    comparou = true;
                }
            }
            if (!comparou) 
                break;
        }
    }
}
