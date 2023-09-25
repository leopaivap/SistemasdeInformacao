package src;

public class BubbleSortDecrescente {

    public static void bSort(int array[]) {
        for (int fase = 1; fase < array.length; fase++) {
            for (int comp = 0; comp < array.length - fase; comp++) {
                if (array[comp] < array[comp + 1]) {
                    int temp = array[comp];
                    array[comp] = array[comp + 1];
                    array[comp + 1] = temp;
                }
            }
        }
    }
}
