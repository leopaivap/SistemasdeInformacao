package Exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TesteExcessoes01 {
    public static void main(String[] args) {
        //File x = new File("C:\Users\02210412650/teste.txt");
        Scanner entrada = null;
        try {
            entrada  = new Scanner(new File("C:\\Users\\02210412650\\teste.txt"));    
        } catch(FileNotFoundException ex){
            System.out.println("Erro ao abrir arquivo!");
        }
        
        while(entrada.hasNextLine()){
            System.out.println(entrada.nextLine());
            
        }
    }
}
