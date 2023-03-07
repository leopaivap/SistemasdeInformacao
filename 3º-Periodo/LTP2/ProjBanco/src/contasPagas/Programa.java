/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contasPagas;

/**
 *
 * @author 02210412650
 */
public class Programa {
    public static void main(String[] args) {
        Produto prod1 = new Produto();
        Produto prod2 = new Produto();
        
        Cliente cli1 = new Cliente();
        Cliente cli2 = new Cliente();
        
        Conta conta1 = new Conta();
        Conta conta2 = new Conta();
        
        prod1.setDescricaoProduto("Notebook core i7");
        prod1.setValorProduto(2500);
        prod2.setDescricaoProduto("TV LED 42'");
        prod2.setValorProduto(1800);
        
        cli1.setNomeCliente("Leonardo");
        cli1.setCpf(101010101);
        cli2.setNomeCliente("Outro Cliente");
        cli2.setCpf(909090909);
        
        conta1.setIdConta(1);
        conta1.setDataVencimento("07/03/2023");
        conta1.setDataPagamento("02/03/2023");
        conta1.cli = cli1;
        conta1.pro = prod1;

        
        conta2.setIdConta(2);
        conta2.setDataVencimento("10/04/2023");
        conta2.setDataPagamento("26/03/2023");
        conta2.cli = cli2;
        conta2.pro = prod2;

        
        conta1.vizualizarConta();
        conta2.vizualizarConta();
        
        
        
        
        
       
    }
}
