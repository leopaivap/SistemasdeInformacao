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
public class Conta {
    private int idConta;
    private String dataVencimento, dataPagamento;
    
    Produto pro = new Produto();
    Cliente cli = new Cliente();

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

 
    
    
    void vizualizarConta(){
        System.out.println("CONTAS PAGAS");
        System.out.println("Indentificador: " + getIdConta());
        System.out.println("Produto: " + pro.getDescricaoProduto());
        System.out.println("Cliente: " + cli.getNomeCliente() + "  CPF: " + cli.getCpf());
        System.out.println("Valor: R$" + pro.getValorProduto());
        System.out.println("Data Vencimento: " + getDataVencimento());
        System.out.println("Data Vencimento: " + getDataPagamento());
        System.out.println("--------------------------");
    }
}
