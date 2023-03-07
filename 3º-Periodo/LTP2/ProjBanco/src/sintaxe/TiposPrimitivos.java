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
public class TiposPrimitivos {

    public static void main(String[] args) {
        byte idade = -128;
        short nPais = 32767;
        int nAluno = -2147483648;
        Integer nAlunos2;
        long nHabitante = 1000000000000000000L;
        

        float salario = 1000.35f;
        double totalSalario = 1009000.35;
        Double totalSalrio2;

        boolean opcao = true;

        char sexo = 'F';

        System.out.println("Byte: " + idade);
        System.out.println("Short: " + nPais);
        System.out.println("Int: " + nAluno);
        System.out.println("Long: " + nHabitante);
        System.out.println("Float: " + salario);
        System.out.println("Double: " + totalSalario);
        System.out.println("Boolean: " + opcao);
        System.out.println("Char: " + sexo);

    }

}
