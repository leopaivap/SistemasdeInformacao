package javasorts;

public class InsertionSort {
    
    public static long comparacoes = 0, deslocamento = 0;

    private static void insert(int array[], int i) {
        int eleito = array[i], comp = i - 1;
        while (comp >= 0 && eleito < array[comp]) {
            comparacoes++;
            
            array[comp + 1] = array[comp]; //deslocando
            deslocamento++;
            comp--;
        }
        comparacoes++; // conta a comparacao de saida
        
        //inserindo o eleito na posicao correta
        array[comp + 1] = eleito;
    }
    
    public static void iSort(int array[]) {
        for (int i = 1; i < array.length; i++) 
            insert(array, i);
    }
}
