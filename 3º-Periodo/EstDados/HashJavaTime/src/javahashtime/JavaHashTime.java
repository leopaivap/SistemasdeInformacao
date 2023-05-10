package javahashtime;
import java.util.*;

public class JavaHashTime {

     public static void main(String[] args) {
       // Hash Map ------------------------------------
        HashMap<Integer,String> pessoaHashMap = new HashMap<>();

        long tempoInicial = System.currentTimeMillis();
        
        for (int i = 0; i < 100000; i++) { pessoaHashMap.put(i,"Pessoa"+i); }
        for (int i = 0; i < 100000; i++) { pessoaHashMap.containsKey(i); }

        long tempoFinal = System.currentTimeMillis(); 
        System.out.printf("Hash: %.3f segundos%n", (tempoFinal - tempoInicial) / 1000.00); 
        //------------------------- Array List
        ArrayList<Integer> pessoaArray = new ArrayList<>();
        tempoInicial = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) { pessoaArray.add(i); }
        for (int i = 0; i < 100000; i++) { pessoaArray.contains(i); }
        tempoFinal = System.currentTimeMillis(); 
        System.out.printf("Array: %.3f segundos%n", (tempoFinal - tempoInicial) / 1000.00); 
    }
}
