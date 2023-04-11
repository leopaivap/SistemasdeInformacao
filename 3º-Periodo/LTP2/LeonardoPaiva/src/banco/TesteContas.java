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
public class TesteContas {
    public static void main(String[] args) {
        //Conta conta = new Conta();
        ContaCorrente contaCc = new ContaCorrente();
        ContaPoupanca contaP = new ContaPoupanca();
        
        //conta.deposita(1000);
        contaCc.deposita(1000);
        contaP.deposita(1000);
        
       // conta.atualiza(0.10);
        contaCc.atualiza(0.10);
        contaP.atualiza(0.10);
        
       // System.out.println("Saldo Conta: R$" + conta.getSaldo());
        System.out.println("Saldo Conta Corrente: R$" + contaCc.getSaldo());
        System.out.println("Saldo Conta Poupanca: R$" + contaP.getSaldo());
        
        /*
        "Após imprimir o saldo (getSaldo()) de cada uma das contas, o que acontece?"
            Após imprimir o saldo de cada conta, todos os valores são diferentes devido 
            ao fato de que cada conta tem uma taxa diferente, alterada pelos métodos reescritos.
        */
    }
}
