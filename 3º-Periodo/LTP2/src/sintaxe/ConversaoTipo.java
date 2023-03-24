/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sintaxe;

/**
 *
 * @author tulio
 */
public class ConversaoTipo {
    public static void main(String[] args) {
        String nome = "Paola Dias Guimarães"; // entrada usuário
        String idade = "14";
        String salario = "5000";
        
        int idade2 = Integer.parseInt(idade);
        idade2 = idade2+1;
        double salario2 = Double.parseDouble(salario);
        System.out.println("Idade convertida:"+idade2);
        System.out.println("Salário convertido:"+salario2);
        
        
    }
    
}
