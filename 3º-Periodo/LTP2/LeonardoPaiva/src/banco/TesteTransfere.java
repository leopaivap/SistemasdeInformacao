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
public class TesteTransfere {
    public static void main(String[] args) {
        Conta minhaConta = new ContaCorrente();
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite um valor para despósito:");
        try{
            minhaConta.deposita(entrada.nextDouble());
    }   catch(ValorInvalidoException e){
            System.out.println(e.getMessage());
    }
        
        Conta outraConta = new ContaCorrente();
        
        try {
            outraConta.deposita(5000);
    } catch(ValorInvalidoException e){
            System.out.println(e.getMessage());
    }
        
        minhaConta.transfere(outraConta, 20000);
        System.out.println("Saldo minha conta:"+minhaConta.getSaldo());
        System.out.println("Saldo outra conta:"+outraConta.getSaldo());
    }
    
}
