/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contasPagas;

/**
 *
 * @author tulio
 */
public class Programa {
    public static void main(String[] args) {
        Produto prod1 = new Produto();
        Produto prod2 = new Produto();
        Cliente cli1  =new Cliente();
        Cliente cli2  =new Cliente();
        Conta conta1 = new Conta();
        Conta conta2 = new Conta();
        prod1.setDescricaoProduto("Note");
        prod1.setValorProduto(5000);
        prod2.setDescricaoProduto("TV");
        prod2.setValorProduto(4000);
        
        cli1.setNomeCliente("Tulio");
        cli1.setCpf("098938493");
        cli2.setNomeCliente("Daniela");
        cli2.setCpf("09098080");
        conta1.setIdConta(212);
        conta1.setDataPagamento("17/03/2023");
        conta1.setDataVencimento("20/03/2023");
        conta2.setIdConta(212);
        conta2.setDataPagamento("20/03/2023");
        conta2.setDataVencimento("24/03/2023");
        conta1.cli = cli1;
        conta1.pro = prod1;
        conta2.cli = cli2;
        conta2.pro = prod2;
        conta1.visualizarConta();
        conta2.visualizarConta();
        
       

    }
    
}
