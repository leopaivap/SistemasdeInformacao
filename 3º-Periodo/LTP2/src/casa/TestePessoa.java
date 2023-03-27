/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casa;

import java.util.Scanner;

/**
 *
 * @author tulio
 */
public class TestePessoa {
    public static void main(String[] args) {
        Pessoa objPessoa = new Pessoa();
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Digite seu nome:");
        objPessoa.setNome(entrada.nextLine());
        System.out.println("Digite seu idade:");
        objPessoa.setIdade(entrada.nextInt());
        objPessoa.fazAniversario();
        objPessoa.mostra();
    }
    
}
