/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author tulio
 */
public class Conta {
// atributos ou variáveis de instância
    Cliente objCliente1 = new Cliente(); // criei um objeto
    Cliente objCliente2; // criei uma referência
    private double saldo;
    private double  limite;
    
    public double getSaldo(){
        return this.saldo;
    }

    public void deposita(double saldo) { // método
        this.saldo = this.saldo + saldo;
        System.out.println("Depósito realizado para: "+objCliente1.getNome());
        
       
    }

    public boolean saca(double saldo) { // método
        if (this.saldo >= saldo) {
            this.saldo = this.saldo - saldo;
            System.out.println("Saque realizado com sucesso");
            return true;
        } else {
            System.out.println("Saldo insuficiente");
            return false;
        }
    }

    boolean transfere(Conta destino, double saldo) {
        if (this.saca(saldo) == true) {
            destino.deposita(saldo);
            return true;
        } else {
            return false;
        }
    }

}
