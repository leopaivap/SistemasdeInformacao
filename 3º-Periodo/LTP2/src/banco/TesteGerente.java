/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author 02210412650
 */
public class TesteGerente {
    public static void main(String[] args) {
        Gerente objGerente = new Gerente();
        Funcionario objFuncionario = new Funcionario();
        
        objFuncionario.setSalario(5000);
        objGerente.setSalario(5000);
        
        objGerente.setNomeFuncionario("Gerente Teste 01");
        System.out.println("Nome Gerente: " + objGerente.getNomeFuncionario());
        System.out.println("Bonificacao Gerente: R$" + objGerente.getBonificacao());
        objGerente.autentica(11133);
        
        objFuncionario.setNomeFuncionario("Funcionario teste 01");
        System.out.println("\nNome Funcionario: " + objFuncionario.getNomeFuncionario());
        System.out.println("Bonificacao Funcionario: R$" + objFuncionario.getBonificacao());
        


    }
}
