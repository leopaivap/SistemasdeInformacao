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
public class TesteReferencia02 {
    public static void main(String[] args) {
        Conta minhaConta = new Conta();
        Cliente cliPedro = new Cliente();
        minhaConta.objCliente2 = cliPedro;
        minhaConta.objCliente2.setNome("Pedro");
        System.out.println("Cliente: "+minhaConta.objCliente2.getNome());
    }
    
}
