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
public class TesteConstrutor {
    public static void main(String[] args) {
        Conta x = new Conta();
        Conta y = new Conta(6000);
        Conta z = new Conta(100000, 9173);
        System.out.println("Saldo conta Z= "+z.getSaldo());
        System.out.println("Número conta Z= "+z.getNumero());
        System.out.println("Total de contas: "+Conta.getTotalDeContas());
    }
    
}
