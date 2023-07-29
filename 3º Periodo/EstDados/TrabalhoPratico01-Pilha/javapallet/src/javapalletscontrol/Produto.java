
package javapalletscontrol;

public class Produto {
    private String descricao;
    private int quantidade;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String produto) {
        this.descricao = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int qtd) {
        this.quantidade = qtd;
    }
    
    @Override
    public String toString(){
        return getDescricao()+ " : " + getQuantidade();
    }
    
}// fim classe
