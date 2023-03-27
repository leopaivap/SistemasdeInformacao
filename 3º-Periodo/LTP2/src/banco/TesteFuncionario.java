/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.util.Scanner;

/**
 *
 * @author tulio
 */
public class TesteFuncionario {
    public static void main(String[] args) {
        Funcionario objFuncionario = new Funcionario();
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite seu nome:");
        objFuncionario.setNomeFuncionario(entrada.nextLine());
        System.out.println("Digite a data de entrada:");
        objFuncionario.setDataEntrada(entrada.next());
        objFuncionario.setDepartamento("RH");
        objFuncionario.setRG("m989998");
        objFuncionario.setSalario(30000);
        System.out.println("Digite a bonificação:");
        objFuncionario.bonifica(entrada.nextDouble());
        objFuncionario.demite();
        objFuncionario.mostra();
    }
    
}
