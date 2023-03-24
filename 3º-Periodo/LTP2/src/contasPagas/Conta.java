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
public class Conta {
    
    private int idConta;
    private String dataVencimento, dataPagamento;
    Produto pro;
    Cliente cli;

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

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
    
    
    
    public void visualizarConta(){
        System.out.println("id conta"+this.idConta);
        System.out.println("Produto: "+this.pro.getDescricaoProduto());
        System.out.println("Nome: "+this.cli.getNomeCliente()+" CPF: "+this.cli.getCpf());
        System.out.println("Valor Produto: "+this.pro.getValorProduto());
        System.out.println("Vencimento: "+this.dataVencimento);
        System.out.println("Pagamento: "+this.dataPagamento);
        System.out.println("------------------------------------------");
    
}
}